package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapters.NewsAdapter
import com.example.newsapp.databinding.FragmentBreakingNewsBinding
import com.example.newsapp.models.Article
import com.example.newsapp.ui.NewsActivity
import com.example.newsapp.util.Resource

class BreakingNewsFragment : Fragment(){

    private lateinit var binding: FragmentBreakingNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)

        val newsViewModel by lazy {
            (activity as NewsActivity).viewModel
        }

        newsViewModel.getBreakingNews("us")

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsViewModel by lazy {
            (activity as NewsActivity).viewModel
        }

        val newsAdapter by lazy {
            NewsAdapter()
        }

        binding.newsView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                 R.id.action_breakingNewsFragment_to_articleFragment,
                 bundle
            )
        }

        newsViewModel.breakingNews.observe(viewLifecycleOwner) {resource ->
            resource?.let { mResource ->
                when(mResource){
                    is Resource.Loading -> {}
                    is Resource.Error -> {}
                    else -> {
                        newsAdapter.differ.submitList(mResource.data?.articles?.toMutableList() ?: mutableListOf<Article>())
                    }
                }
            }
        }
    }
}