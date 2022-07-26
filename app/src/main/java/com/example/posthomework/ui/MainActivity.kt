package com.example.posthomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posthomework.R
import com.example.posthomework.data.api.RetrofitBuilder
import com.example.posthomework.data.repository.PostRepository

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel:MainViewModel
    private val adapter by lazy {
        PostAdapter()}
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val repository = PostRepository()
        recyclerView.adapter =adapter
        val mainViewModelFactory  = MainaViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
        getData()

    }
        private fun getData() {
            mainViewModel.getDataFromApi()
            mainViewModel.response.observe(this, Observer {
                adapter.setData(it.body()!!)

            })

}}



