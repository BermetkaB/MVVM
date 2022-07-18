package com.example.posthomework.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.posthomework.R
import com.example.posthomework.data.model.Post

class PostAdapter():RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    private var list:List<Post> = emptyList()
    class PostViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        val tv_title:TextView = itemView.findViewById(R.id.tv_title)
        val tv_body:TextView= itemView.findViewById(R.id.tv_body)
        val tv_id:TextView=itemView.findViewById(R.id.tv_id)
        val tv_userId:TextView=itemView.findViewById(R.id.tv_userId)
    }

    fun setData( newList:List<Post>){
        this.list = newList
        notifyDataSetChanged()}

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
          val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
          return PostViewHolder(view)

      }

      override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=list[position]
          holder.tv_body.text=post.body
          holder.tv_title.text=post.title
          holder.tv_id.text=post.id.toString()
          holder.tv_userId.text=post.userId.toString()
      }

      override fun getItemCount(): Int {
          return list.size
      }
  }