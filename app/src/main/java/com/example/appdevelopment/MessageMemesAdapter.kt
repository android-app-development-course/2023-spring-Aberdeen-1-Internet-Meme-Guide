package com.example.appdevelopment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageMemesAdapter(private val dataSet: List<MessageMemes>) :
    RecyclerView.Adapter<MessageMemesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val pic5ImageView: ImageView = view.findViewById(R.id.pic5)
        val text10TextView: TextView = view.findViewById(R.id.text10)
        val text20TextView: TextView = view.findViewById(R.id.text20)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message_meme, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet[position]

        holder.pic5ImageView.setImageResource(data.srcCompat1)
        holder.text10TextView.text = data.name3
        holder.text20TextView.text = data.view3
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
    }