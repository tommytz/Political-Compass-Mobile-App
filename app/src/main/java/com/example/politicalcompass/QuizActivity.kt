package com.example.politicalcompass

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity(){
    val nextButton : Button = findViewById<Button>(R.id.next_btn)

    val radioGroup : RadioGroup = findViewById(R.id.radio_group)

    private val strongAgree : RadioButton = findViewById(R.id.strong_agree)
    private val agree : RadioButton = findViewById(R.id.agree)
    private val neutral : RadioButton = findViewById(R.id.neutral)
    private val disagree : RadioButton = findViewById(R.id.disagree)
    private val strongDisagree : RadioButton = findViewById(R.id.strong_disagree)

    val answers = listOf<RadioButton>(strongAgree, agree, neutral, disagree, strongDisagree)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_activity)

        }

}
