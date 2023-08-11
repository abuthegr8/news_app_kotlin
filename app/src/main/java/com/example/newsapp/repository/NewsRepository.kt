package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitHelper

class NewsRepository(
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitHelper.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitHelper.api.searchForNews(searchQuery, pageNumber)
}