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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding by lazy {
            FragmentArticleBinding.inflate(inflater, container, false)
        }

        val newsViewModel by lazy {
            (activity as NewsActivity).viewModel
        }

        val webView = binding.webView
        val article = arguments?.getSerializable("article") as Article

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
            settings.setSupportZoom(true)
        }


        binding.saveButton.setOnClickListener{
            newsViewModel.saveArticle(article)
            view?.let { it1 -> Snackbar.make(it1, "Article saved successfully", Snackbar.LENGTH_SHORT).show() }
        }
        return binding.root
    }
}