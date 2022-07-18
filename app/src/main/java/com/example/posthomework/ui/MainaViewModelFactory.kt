package com.example.posthomework.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.posthomework.data.api.RetrofitBuilder


class MainaViewModelFactory(val repository: RetrofitBuilder): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): MainViewModel {
        return MainViewModel(repository)
    }
}