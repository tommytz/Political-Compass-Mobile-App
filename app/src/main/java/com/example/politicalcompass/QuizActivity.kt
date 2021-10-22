package com.example.politicalcompass

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_activity)
    }

    /* This function is called by the next button in the quiz xml. It takes the input from the radio group and then unchecks the buttons for the next question.*/
    fun nextQuestion(view: View) {
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)

        val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
        val checkedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
        Toast.makeText(this, checkedRadioButton.text, Toast.LENGTH_SHORT).show()
        radioGroup.clearCheck()
    }
}
