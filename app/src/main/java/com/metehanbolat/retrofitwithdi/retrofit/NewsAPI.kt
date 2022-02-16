package com.metehanbolat.retrofitwithdi.retrofit

import com.metehanbolat.retrofitwithdi.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

interface NewsAPI {

    @GET("top-headlines?country=tr&apiKey=9df663ddf6464d11a1d7601967f8f33f")
    suspend fun getNewsFromApi(): Response<NewsModel>
}