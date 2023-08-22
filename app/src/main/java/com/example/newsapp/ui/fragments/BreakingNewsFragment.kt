package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapters.NewsAdapter
import com.example.newsapp.databinding.FragmentBreakingNewsBinding
import com.example.newsapp.ui.NewsActivity
import com.example.newsapp.util.Resource

class BreakingNewsFragment : Fragment(){

    private lateinit var binding: FragmentBreakingNewsBinding

    private val newsViewModel by lazy {
        (activity as NewsActivity).viewModel
    }

    private val newsAdapter by lazy {
        NewsAdapter()
    }

    private val TAG = "BreakingNewsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)

        newsViewModel.getBreakingNews("us")

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            val fragment = ArticleFragment()
            fragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id._fragment_main, fragment )
                .addToBackStack(null)
                .commit()
        }

        newsViewModel.breakingNews.observe(viewLifecycleOwner) {response ->
                when(response){
                    is Resource.Success -> {
                        response.data?.let { newsResponse ->
                            newsAdapter.differ.submitList(newsResponse.articles)
                        }
                    }
                    is Resource.Error -> {
                        response.message?.let { message ->
                            Log.e(TAG, "An error occurred: $message")
                            Toast.makeText(activity, "An error occured: $message", Toast.LENGTH_LONG).show()
                        }
                    }
                    is Resource.Loading -> {}
                }
        }
    }
}