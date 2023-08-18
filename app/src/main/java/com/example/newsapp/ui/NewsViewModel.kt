package com.example.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.RetrofitHelper.api
import com.example.newsapp.models.Article
import com.example.newsapp.models.NewsResponse
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.UnknownHostException

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {
    var breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    var searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getBreakingNews(countryCode: String) = viewModelScope.launch { Dispatchers.IO
        breakingNews.postValue(Resource.Loading())//dispatcher, default
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {Dispatchers.IO
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuery, searchNewsPage)
        searchNews.postValue((handleSearchNewsResponse((response))))//postvalue
    }

    fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        try {
            if (response.isSuccessful) {
                response.body()?.let { resultResponse ->
                    return Resource.Success(resultResponse)
                }
            } else {
                if (response.code() == 404) {
                    _errorLiveData.value = "Error 404"
                } else {
                    _errorLiveData.value = "An error occurred"
                }
            }
        } catch (e: Exception) {
            _errorLiveData.value = "Network error"
        } catch (e: UnknownHostException) {
            _errorLiveData.value = "Host or API url not found"
        }
        return Resource.Error(response.message())
    }

    fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveArticle(article: Article) = viewModelScope.launch {Dispatchers.IO
        newsRepository.upsert(article)
    }

    fun getSavedNews() = newsRepository.getSavedNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {Dispatchers.IO
        newsRepository.deleteArticle(article)
    }
}