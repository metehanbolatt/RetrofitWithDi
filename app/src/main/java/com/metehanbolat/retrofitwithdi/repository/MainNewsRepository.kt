package com.metehanbolat.retrofitwithdi.repository

import com.metehanbolat.retrofitwithdi.model.NewsModel
import com.metehanbolat.retrofitwithdi.retrofit.NewsAPI
import com.metehanbolat.retrofitwithdi.util.Resource
import kotlinx.coroutines.delay
import javax.inject.Inject

class MainNewsRepository @Inject constructor(
    private val newsAPI: NewsAPI
): NewsRepository {
    override suspend fun getNewAllNews(): Resource<NewsModel> {
        return try {
            val response = newsAPI.getNewsFromApi()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occurred", null)
            }else {
                Resource.error("An unknown error occurred", null)
            }
        } catch (e: Exception) {
            Resource.error("Check your internet connection!", null)
        }
    }
}