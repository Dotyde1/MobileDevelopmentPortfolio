package com.example.l3t2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_portal.*
const val EXTRA_PORTAL = "EXTRA_PORTAL"

class AddPortalActivity : AppCompatActivity() {
    private var portalContent = arrayListOf<Portals>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal)
        initViews()
    }

    private fun initViews() {
        button_AddPortal.setOnClickListener { onConfirmClick() }
    }

    private fun onConfirmClick() {


        if (sSiteName.text.toString().isNotBlank() && sUrlLink.text.toString().isNotBlank()) {
            val portal = Portals(sSiteName.text.toString(), sUrlLink.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        else{
            Toast.makeText(this,"Please fill in all text fields"
                , Toast.LENGTH_SHORT).show()
        }


    }
}