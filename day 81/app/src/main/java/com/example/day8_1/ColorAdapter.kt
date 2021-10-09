package com.example.day8_1

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(private val items : MutableList<com.example.day8_1.Model.Color>) :
RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {
    class ColorViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val textColorCode = view.findViewById<TextView>(R.id.txtColorCode)
        companion object{
            fun from(parent : ViewGroup) : ColorViewHolder{
                return ColorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.color_item, parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.textColorCode.text = items[position].hex
        holder.view.setBackgroundColor(Color.parseColor(items[position].hex))

        holder.view.setOnClickListener {
            val intent = Intent(
                holder.view.context, ColorDetailActivity::class.java
            )
            intent.putExtra("color", items[position])

            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun changeData(newItems : List<com.example.day8_1.Model.Color>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}