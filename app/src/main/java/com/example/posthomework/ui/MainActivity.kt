package com.example.posthomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posthomework.R
import com.example.posthomework.data.api.RetrofitBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel:MainViewModel
    private val adapter by lazy {
        PostAdapter()
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val repository =RetrofitBuilder()
        recyclerView.adapter = adapter
        val mainViewModelFactory  = MainaViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
        getData()

    }
        private fun getData() {
            mainViewModel.getDataFromApi()
            mainViewModel.response.observe(this, Observer {
                adapter.setData(it.body()!!)

            })

}}}