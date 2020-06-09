package com.example.sos_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        btn_map.setOnClickListener { onMapClick() }
    }
    private fun onMapClick() {
        startActivity( Intent(this@MainActivity, MapActivity::class.java))
    }

}
