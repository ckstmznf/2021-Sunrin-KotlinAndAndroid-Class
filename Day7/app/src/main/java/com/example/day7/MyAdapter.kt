package com.example.day7

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val data : Array<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //data는 리스트로 보여줄 배열이다.
    // 제네릭으로 뷰홀더를 넘겨주주 않으면 오류가 나고있다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //새 뷰 홀더 객체를 만들어준다.
        val inflater = LayoutInflater.from(parent.context)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
//        val holder = MyViewHolder(view)
//        holder.view.setOnClickListener{
//            Toast.makeText(
//                parent.context,
//                holder.textView.text.toString(),
//                Toast.LENGTH_LONG)
//                .show()
//        }


        return when(viewType){
            VIEW_TYPE.COLOR.ordinal -> MyViewHolder(inflater.inflate(R.layout.item, parent, false))
            else -> ColorViewHolder(inflater.inflate(R.layout.color_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //postion은 몇번째에 보여준는지 -> 몇번째 데이터를 넘겨줘야 하는지
//        holder.textView.text = data[position].toString()


        when(holder){
            is ColorViewHolder -> holder.view.setBackgroundColor(Color.parseColor(data[position] as String))
            is MyViewHolder -> holder.textView.text = data[position].toString()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]){
            is Int -> {
                VIEW_TYPE.NUMBER.ordinal
            }
            else -> {
                VIEW_TYPE.COLOR.ordinal
            }
        }
    }

    override fun getItemCount(): Int {
        //보여줄 데이터배열의 크기
        return data.size
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        //이때 view는 아이템이 들어온다.
        val textView = view.findViewById<TextView>(R.id.textView)
    }
    class ColorViewHolder(val view : View) : RecyclerView.ViewHolder(view){

    }
}

enum class VIEW_TYPE{
    NUMBER,
    COLOR
}