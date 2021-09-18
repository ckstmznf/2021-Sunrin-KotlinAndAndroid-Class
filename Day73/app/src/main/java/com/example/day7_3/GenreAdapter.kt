package com.example.day7_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenreAdapter(private val items : List<Genre>) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>(){
    class GenreViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        companion object{
            fun from(parent: ViewGroup) : GenreViewHolder{
                return GenreViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.genreitem, parent, false
                ))
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreAdapter.GenreViewHolder {
        return GenreViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: GenreAdapter.GenreViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.genre_title).text = items[position].name
        holder.view.findViewById<RecyclerView>(R.id.m_list).adapter = MovieAdapter(items[position].movies)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}