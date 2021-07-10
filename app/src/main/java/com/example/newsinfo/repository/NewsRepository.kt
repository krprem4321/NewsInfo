package com.example.newsinfo.repository

import com.example.newsinfo.network.networkService.NewsService
import com.example.newsinfo.model.News
import retrofit2.Call

class NewsRepository {

    fun getNewsHeadlines(country: String,page:Int): Call<News> {
        return NewsService.newInstance.getHeadlines(country,page)
    }
}