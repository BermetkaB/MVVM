package com.example.posthomework.data.api

import com.example.posthomework.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    interface PostApi {
        @GET("posts")
        suspend fun getPosts(): Response<List<Post>>
    }

}