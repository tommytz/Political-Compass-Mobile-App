package com.example.politicalcompass

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class QuizActivity : AppCompatActivity() {
    private val answers = HashMap<Int, String>()
    var questionCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_activity)
    }

    /* This function is called by the next button in the quiz xml. It takes the input from the radio group and then unchecks the buttons for the next question.*/
    fun nextQuestion(view: View) {
        val questionText : TextView = findViewById(R.id.quiz_question)
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)

        val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
        val checkedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
        val answer = checkedRadioButton.text

        addAnswer(questionCount, answer as String) // need to have a count for question
        radioGroup.clearCheck()

        if (questionCount <= 4) {
            println("Questions answered: $questionCount") // We should ideally be using this to cycle through the questions
        } else {
            result(questionText)
        }
        questionCount++


    }

    fun addAnswer(question: Int, answer: String) {
        answers[question] = answer
        println("Question number $question - Answer: $answer")
    }

    /* This function creates a new results object, gets a fragment to open the results activity, then resets the quiz answers and question number */
    fun result(questionText : TextView) {
        val quizResultFragment = QuizResult(answers).score()
        val fragmentID = quizResultFragment.id

        // Reset quiz questions and answers
        answers.clear()
        questionCount = 1
        questionText.text = R.string.firstQuestion.toString()

        // Something to go to a new activity using the fragment from quiz score
        val intent = Intent(this, QuizResultActivity::class.java)
        intent.putExtra("fragmentToLoad", fragmentID)
        startActivity(intent)
    } // CONSIDER JUST SENDING AN INT INSTEAD
}







