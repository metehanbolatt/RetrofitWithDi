package com.metehanbolat.retrofitwithdi.viewmodel

import androidx.lifecycle.ViewModel
import com.metehanbolat.retrofitwithdi.model.NewsModel
import com.metehanbolat.retrofitwithdi.repository.MainNewsRepository
import com.metehanbolat.retrofitwithdi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepository: MainNewsRepository): ViewModel() {

    suspend fun getNews(): Resource<NewsModel> = newsRepository.getNewAllNews()


}