package com.example.appnews.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.appnews.data.model.APIResponse
import com.example.appnews.data.model.Article
import com.example.appnews.data.util.NetworkUtils
import com.example.appnews.data.util.Resource
import com.example.appnews.domain.usecase.GetNewsHeadlinesUseCase
import com.example.appnews.domain.usecase.GetSavedNewsUseCase
import com.example.appnews.domain.usecase.GetSearchedNewsUseCase
import com.example.appnews.domain.usecase.SaveNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val application: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase
) : AndroidViewModel(application) {

    private val newsHeadlinesLV = MutableLiveData<Resource<APIResponse>>()
    val newsHeadLine: LiveData<Resource<APIResponse>> = newsHeadlinesLV

    private val searchNewsLV = MutableLiveData<Resource<APIResponse>>()
    val searchNews: LiveData<Resource<APIResponse>> = searchNewsLV

    fun getNewsHeadline(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadlinesLV.postValue(Resource.Loading())
        try {
            if (NetworkUtils.isNetworkAvailable(application)) {
                val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadlinesLV.postValue(apiResult)
            } else {
                newsHeadlinesLV.postValue(Resource.Error(message = INTERNET_NOT_AVAILABLE_MESSAGE))
            }
        } catch (exception: Exception) {
            newsHeadlinesLV.postValue(Resource.Error(message = exception.message.toString()))
        }
    }

    fun getSearchedNews(country: String, searchQuery: String, page: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            newsHeadlinesLV.postValue(Resource.Loading())
            try {
                if (NetworkUtils.isNetworkAvailable(application)) {
                    val apiResult = getSearchedNewsUseCase.execute(country, searchQuery, page)
                    newsHeadlinesLV.postValue(apiResult)
                } else {
                    newsHeadlinesLV.postValue(Resource.Error(message = INTERNET_NOT_AVAILABLE_MESSAGE))
                }
            } catch (exception: Exception) {
                newsHeadlinesLV.postValue(Resource.Error(message = exception.message.toString()))
            }
        }

    fun saveArticle(article: Article) =
        viewModelScope.launch(Dispatchers.IO) {
            saveNewsUseCase.execute(article)
        }

    fun getSavedArtiles() = liveData {
        getSavedNewsUseCase.execute().collect { emit(it) }
    }

    companion object {
        private const val INTERNET_NOT_AVAILABLE_MESSAGE = "internet not available"
    }
}