package com.example.newsapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.ui.fragments.BreakingNewsFragment
import com.example.newsapp.ui.fragments.SavedNewsFragment
import com.example.newsapp.ui.fragments.SearchNewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : FragmentActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val binding by lazy {
            ActivityNewsBinding.inflate(layoutInflater)
        }

        val view = binding.root
        setContentView(view)

        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.breakingNewsFragment -> {
                    val fragment = BreakingNewsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id._fragment_main, fragment)
                        .commit()
                    true
                }
                R.id.savedNewsFragment -> {
                    val fragment = SavedNewsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id._fragment_main, fragment)
                        .commit()
                    true
                }
                R.id.searchNewsFragment -> {
                    val fragment = SearchNewsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id._fragment_main, fragment)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}