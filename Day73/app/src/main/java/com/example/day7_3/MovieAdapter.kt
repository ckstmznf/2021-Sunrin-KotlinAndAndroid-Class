package com.example.day7_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        companion object{
            fun from(parent : ViewGroup) : MovieViewHolder{
                return MovieViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.movieitem, parent, false
                ))
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.movieTitle).text = movies[position].name
        holder.view.findViewById<ImageView>(R.id.moviePost).setImageResource(movies[position].poster)
    }

}
