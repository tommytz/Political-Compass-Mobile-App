package com.example.politicalcompass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.quizButton)
        button.setOnClickListener {
            setContentView(R.layout.quiz_activity)
        }

        val button2 : Button = findViewById(R.id.partyButton)
        button2.setOnClickListener {
            setContentView(R.layout.party_activity)
        }

    }
//    val play : CardView = findViewById(R.id.startQuiz)


//    fun startQuiz(view : View){
//        val quizActivityIntent: Intent = Intent(this@MainActivity, QuizActivity::class.java)
//        startActivity(quizActivityIntent)
//    }
}