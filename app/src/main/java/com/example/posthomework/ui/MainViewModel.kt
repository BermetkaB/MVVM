package com.example.posthomework.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.posthomework.data.api.RetrofitBuilder
import retrofit2.Response

class MainViewModel {
    class MainViewModel(val repository: RetrofitBuilder): ViewModel() {
        val response: MutableLiveData<Response<List<Post>>> = MutableLiveData()

        fun getDataFromApi(){
            viewModelScope.launch {
                val result = repository.getData()
                response.value = result
            }
        }
}