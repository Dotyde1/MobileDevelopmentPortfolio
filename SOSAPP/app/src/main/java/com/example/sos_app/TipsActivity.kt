package com.example.sos_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_tips.*

class TipsActivity : AppCompatActivity() {
    private val firstaid = arrayListOf<FirstAid>()
    private val firstaidAdapter = FirstAidAdapter(firstaid)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)
        initViews()
    }

    private fun initViews() {
        rvFirstAid.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvFirstAid.adapter = firstaidAdapter

        // Populate the places list and notify the data set has changed.
        for (i in FirstAid.FIRSTAID.indices) {
            firstaid.add(FirstAid(FirstAid.FIRSTAID[i]))
        }
        firstaidAdapter.notifyDataSetChanged()
    }
}