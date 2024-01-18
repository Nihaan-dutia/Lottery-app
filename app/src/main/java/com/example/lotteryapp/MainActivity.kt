package com.example.lotteryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var titleTextView: TextView
    lateinit var editText: EditText
    lateinit var generateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the widgets
        titleTextView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        generateButton = findViewById(R.id.generatebutton)

        //create functionality
        generateButton.setOnClickListener{
            var name:String = editText.text.toString()

            //explicit intent
            var i = Intent(this,SecondActivity::class.java)
            //username additionality
            i.putExtra("username" , name)
            startActivity(i)
        }
    }

}