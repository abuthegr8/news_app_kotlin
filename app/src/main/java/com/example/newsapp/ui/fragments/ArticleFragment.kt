package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.newsapp.databinding.FragmentArticleBinding
import com.example.newsapp.models.Article
import com.example.newsapp.ui.NewsActivity
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(){

    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsViewModel by lazy {
            (activity as NewsActivity).viewModel
        }

        val article = arguments?.getSerializable("article") as Article

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
            settings.setSupportZoom(true)
        }

        binding.saveButton.setOnClickListener{
            newsViewModel.saveArticle(article)
            view.let { it1 -> Snackbar.make(it1, "Article saved successfully", Snackbar.LENGTH_SHORT).show() }
        }
    }
}