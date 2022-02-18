package com.metehanbolat.retrofitwithdi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.retrofitwithdi.model.NewsModel
import com.metehanbolat.retrofitwithdi.repository.MainNewsRepository
import com.metehanbolat.retrofitwithdi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepository: MainNewsRepository): ViewModel() {

    suspend fun getNews(): Resource<NewsModel> = newsRepository.getNewAllNews()

}