package com.example.l3t2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_portal.*

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal)
        initViews()
    }

    private fun initViews() {
        button_AddPortal.setOnClickListener { onConfirmClick() }
    }

    private fun onConfirmClick() {

        startActivity(
            Intent(
                this@AddPortalActivity,
                MainActivity::class.java
            )
        )

    }
}