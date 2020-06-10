package com.example.l6task2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.l6task2.R
import com.example.l6task2.data.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews() {
        val movie: Movie = intent.getParcelableExtra(MOVIE)

        tvTitle.text = movie.title
        tvRating.text = movie.rating.toString()
        tvRelease.text = movie.releaseDate
        tvOverview.text = movie.overview
        GlideApp.with(this).load(movie.getBackdropImageUrl()).into(ivBackdrop)
        GlideApp.with(this).load(movie.getPosterImageURL()).into(ivPosterDetail)


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
