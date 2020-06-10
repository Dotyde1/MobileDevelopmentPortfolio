package com.example.l6task2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.l6task2.R
import com.example.l6task2.data.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter (private val movies : List<Movie>, private val onClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var movieNum = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie) {
            GlideApp.with(context).load(movie.getPosterImageURL()).into(itemView.ivPoster)
            itemView.tvRank.text = movie.id.toString() + "."
            movieNum++
        }
    }

}