package com.example.day7_2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class GenreAdapter(val items : List<Genre>) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>(){
    class GenreViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        companion object{
            fun from(parent : ViewGroup) : GenreViewHolder{
                return GenreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.genre, parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.genreTitle).text = items[position].name
//        Log.d("movie Name", items[position].name)
        holder.view.findViewById<RecyclerView>(R.id.recycler_main_list).adapter = MovieAdapter(items[position].movies)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}