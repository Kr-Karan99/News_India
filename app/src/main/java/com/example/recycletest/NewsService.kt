package com.example.recycletest

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=in&apiKey=9664790ebb1641859d4d071fc626a8e0
// https://newsapi.org/v2/everything?q=apple&from=2023-08-18&to=2023-08-18&sortBy=popularity&apiKey=9664790ebb1641859d4d071fc626a8e0

const val BASE_URL="https://newsapi.org/"
const val API_KEY="9664790ebb1641859d4d071fc626a8e0"
interface NewsInterface{

    @GET("v2/top-headlines?country=in&apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country :String,@Query("page") page :Int) : Call<News>

    //https://newsapi.org/v2/top-headlines?country=in&apiKey=9664790ebb1641859d4d071fc626a8e0
}

object NewsService{
    val newsInstance : NewsInterface
    init{
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}