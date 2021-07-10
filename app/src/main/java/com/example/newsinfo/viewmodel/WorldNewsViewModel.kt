package com.example.newsinfo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsinfo.model.Articles
import com.example.newsinfo.model.News
import com.example.newsinfo.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "WorldNewsViewModel"

class WorldNewsViewModel(application: Application) :
    AndroidViewModel(application) {

    private var repository: NewsRepository = NewsRepository()
    var isLoading = MutableLiveData<Boolean>()


    var myResponse: MutableLiveData<List<Articles>> = MutableLiveData()

    fun getNews(country: String, page: Int) {

        viewModelScope.launch(Dispatchers.Default) {
            isLoading.postValue(true)
            val news = repository.getNewsHeadlines(country, page)
            news.enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val newsBody = response.body()
                    if (response.isSuccessful && newsBody != null) {
                        myResponse.postValue(newsBody.articles)
                    } else {
                        Log.i(TAG, "onResponse: ${response.code()}  ${response.message()}")
                    }
                    isLoading.postValue(false)
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.i(TAG, "onFailure: ${t.message.toString()}")
                    isLoading.postValue(false)
                }
            })
        }
    }

}