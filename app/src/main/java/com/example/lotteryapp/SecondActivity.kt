package com.example.lotteryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var titleTextView: TextView
    lateinit var textgeneratednumbers: TextView
    lateinit var ShareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //Initializing variables
        titleTextView = findViewById(R.id.textView3)
        textgeneratednumbers = findViewById(R.id.textView4)
        ShareButton = findViewById(R.id.button)


        val randomNumbers = generateRandomNumbers(6)
        titleTextView.text = randomNumbers

        var userName = receiveUserName()

        //share the username and email with different apps
        ShareButton.setOnClickListener{
            shareResult(userName, randomNumbers)
        }


    }
    fun generateRandomNumbers(count:Int):String{
        //list of random numbers
        var randomNumbers = List(count){
            (1..42).random()

        }
        //convert the list to string
        return randomNumbers.joinToString(" ")
        //join to string = converts values into string and creates a seperation which is counted as a variable
    }

    fun receiveUserName(): String{
        //retrieve the extras bounded to the intent
        var bundle:Bundle? = intent.extras

        //give me the key i will give you the value
        var userName = bundle?.getString("username").toString()
        return userName
    }
    // share username and email id with email app
    fun shareResult(username:String , generateNums:String){
        //implicit Intents
        //sending data to another application

        var i = Intent(Intent.ACTION_SEND)

        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT ,  "$username generates these numbers ")
        i.putExtra(Intent.EXTRA_TEXT, "The lottery numbers are: $generateNums")
        startActivity(i)


    }

}