package com.example.politicalcompass

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private val answers = HashMap<Int, String>()

    var questionCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_activity)
    }

    /* This function is called by the next button in the quiz xml. It takes the input from the radio group and then unchecks the buttons for the next question.*/
    fun nextQuestion(view: View) {
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)

        val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
        val checkedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
        val answer = checkedRadioButton.text
        Toast.makeText(this, checkedRadioButton.text, Toast.LENGTH_SHORT).show()

        addAnswer(questionCount, answer as String) // need to have a count for question
        radioGroup.clearCheck()
        if (questionCount <= 4) {
            println("Questions answered: $questionCount")
            TODO("Add logic to change the question text")
        } else {
            result()
        }
        questionCount++


    }

    fun addAnswer(question: Int, answer: String) {
        answers[question] = answer
        println("Question $question - Answer: $answer")
    }

    fun result() {
        TODO("Create QuizResult object passing it the answers map")
        TODO("Get party result from QuizResult public function and go to new activity")
    }
}







