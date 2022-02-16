package com.metehanbolat.retrofitwithdi.repository

import com.metehanbolat.retrofitwithdi.model.NewsModel
import com.metehanbolat.retrofitwithdi.util.Resource

interface NewsRepository {

    suspend fun getNewAllNews(): Resource<NewsModel>
}