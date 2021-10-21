package com.example.politicalcompass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizButton : Button = findViewById(R.id.quizButton)
        quizButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        val partyButton : Button = findViewById(R.id.partyButton)
        partyButton.setOnClickListener {
            val intent = Intent(this, PartyActivity::class.java)
            startActivity(intent)
        }

        val policyButton : Button = findViewById(R.id.policyButton)
        policyButton.setOnClickListener {
            val intent = Intent(this, PolicyActivity::class.java)
            startActivity(intent)
        }

        val electoralButton : Button = findViewById(R.id.electorateButton)
        electoralButton.setOnClickListener {
            val intent = Intent(this, ElectoralActivity::class.java)
            startActivity(intent)
        }

    }
//    val play : CardView = findViewById(R.id.startQuiz)


//    fun startQuiz(view : View){
//        val quizActivityIntent: Intent = Intent(this@MainActivity, QuizActivity::class.java)
//        startActivity(quizActivityIntent)
//    }
}