package com.example.gamescore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val player1points: ArrayList<Int>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    //lateinit var tablica : ArrayList<Int>

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val points : TextView
        init {
            points = view.findViewById(R.id.tv_pointCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.point_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.points.text = player1points[position].toString()
    }

    override fun getItemCount() = player1points.size

    //https://damianchodorek.com/kurs-android-lista-siatka-recyclerview-viewholder-cardview-karty-cien-adapter-wzorzec-16/

}
