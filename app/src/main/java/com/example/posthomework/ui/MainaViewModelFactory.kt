package com.example.posthomework.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.posthomework.data.api.RetrofitBuilder
import com.example.posthomework.data.repository.PostRepository


class MainaViewModelFactory(val repository: PostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}