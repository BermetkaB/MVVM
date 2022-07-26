package com.example.posthomework.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posthomework.data.api.RetrofitBuilder
import com.example.posthomework.data.model.Post
import com.example.posthomework.data.repository.PostRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel
    (val repository: PostRepository): ViewModel() {
        val response: MutableLiveData<Response<List<Post>>> = MutableLiveData()

        fun getDataFromApi(){
            viewModelScope.launch {
                val result = repository.getData()
                response.value = result
            }
        }
}