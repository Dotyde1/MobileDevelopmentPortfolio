package com.example.l1t2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private var CorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }



    private fun initViews() {
        BtnSubmit.setOnClickListener{CheckAnswers()}

    }

    private fun CheckAnswers(){

        if(txtCalc1.getText().toString() == "T") CorrectAnswers++
        if(txtCalc2.getText().toString() == "F") CorrectAnswers++
        if(txtCalc3.getText().toString() == "F") CorrectAnswers++
        if(txtCalc4.getText().toString() == "F") CorrectAnswers++



        Toast.makeText(applicationContext,"The number of correct answers is:" + CorrectAnswers.toString(),Toast.LENGTH_SHORT).show()
        CorrectAnswers = 0
    }


}
