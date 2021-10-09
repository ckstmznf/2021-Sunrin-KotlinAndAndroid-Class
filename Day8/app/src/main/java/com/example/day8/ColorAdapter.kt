package com.example.day8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(private val items : MutableList<Color>) : RecyclerView.Adapter<ColorAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH.from(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.txtColor.text = items[position].hex
        holder.view.setBackgroundColor(android.graphics.Color.parseColor(items[position].hex))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class VH(val view : View) : RecyclerView.ViewHolder(view){
        val txtColor = view.findViewById<TextView>(R.id.txtColorCode)
        companion object{
            fun from(parent : ViewGroup) : VH{
                return VH(LayoutInflater.from(parent.context).inflate(R.layout.color_item, parent, false))
            }
        }
    }
}