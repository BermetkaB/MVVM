package com.example.posthomework.data.repository

import com.example.posthomework.data.api.RetrofitBuilder
import com.example.posthomework.data.model.Post
import retrofit2.Response

class PostRepository {
    suspend fun  getData(): Response<List<Post>> {
        return RetrofitBuilder.api.getPosts()
    }
}