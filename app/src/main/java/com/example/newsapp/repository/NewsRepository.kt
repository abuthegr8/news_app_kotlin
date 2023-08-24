package com.example.newsapp.repository
import com.example.newsapp.api.RetrofitHelper
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.Article

class NewsRepository(
    private val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitHelper.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitHelper.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

    fun getSavedNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)
}