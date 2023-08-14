package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.databinding.FragmentArticleBinding
import com.example.newsapp.models.Article

class ArticleFragment : Fragment(){

    lateinit var binding: FragmentArticleBinding//Not required

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleBinding.inflate(inflater, container, false)

        val webView = binding.webView
        val article = arguments?.getSerializable("article") as Article//how is article being loaded

        webView.webViewClient = WebViewClient()
//        webView.settings.javaScriptEnabled = true

        webView.loadUrl(article.url)
        webView.settings.setSupportZoom(true)
        return binding.root
    }
}