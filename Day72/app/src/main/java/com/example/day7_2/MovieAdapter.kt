package com.example.day7_2

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val items: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        companion object{
            fun from(parent : ViewGroup) : MovieViewHolder {
                return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.view.findViewById<ImageView>(R.id.moviePost).setImageResource(items[position].poster)
        holder.view.findViewById<TextView>(R.id.movieTitle).text = items[position].name
//        holder.view.findViewById<TextView>(R.id.movieDesc).text = items[position].desc
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
