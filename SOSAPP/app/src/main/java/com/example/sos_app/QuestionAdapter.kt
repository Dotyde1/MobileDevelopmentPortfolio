package com.example.sos_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*

public class FirstAidAdapter(private val firstAid: List<FirstAid>) :
    RecyclerView.Adapter<FirstAidAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return firstAid.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(firstAid[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(firstAid: FirstAid) {
            itemView.FirstAid.text = firstAid.firstAid
        }
    }
}