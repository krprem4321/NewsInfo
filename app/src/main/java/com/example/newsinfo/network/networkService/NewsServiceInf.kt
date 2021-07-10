package com.example.newsinfo.network.networkService

import com.example.newsinfo.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=API_KEY

const val BASE_URL="https://newsapi.org/"
const val API_KEY="4076d01b89d94ae38a81f167a07d4b22"

interface NewsServiceInf {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String,@Query("page") page:Int):Call<News>
}
object NewsService{
    val newInstance: NewsServiceInf
    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newInstance =retrofit.create(NewsServiceInf::class.java)
    }
}