package com.example.politicalcompass

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private val answers = HashMap<Int, String>()
    private var questionCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_activity)
    }

    /* This function is called by the next button in the quiz xml. It takes the input from the radio group and then unchecks the buttons for the next question.*/
    fun nextQuestion(view: View) {
        val question: TextView = findViewById(R.id.quiz_question)
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)


        val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
        if (selectedRadioButtonId == -1) {  //selectedRadioButtonID is -1 if nothing is selected
            Toast.makeText(this, "Please select option before continuing", Toast.LENGTH_SHORT)
                .show()
        } else {
            val checkedRadioButton: RadioButton = findViewById(selectedRadioButtonId)

            // Save answer to map
            val answer = checkedRadioButton.text

            addAnswer(questionCount, answer as String) // need to have a count for question
            radioGroup.clearCheck()

            // Increment question and change question string accordingly
            questionCount++
            if (questionCount > 4) {
                result(question)
            }
            provideQuestionText(question)
        }
    }

    private fun provideQuestionText(questionText: TextView): String {
        if (questionCount == 1) {
            questionText.text = getString(R.string.firstQuestion)
        }
        if (questionCount == 2) {
            questionText.text = getString(R.string.secondQuestion)
        }
        if (questionCount == 3) {
            questionText.text = getString(R.string.thirdQuestion)
        }
        if (questionCount == 4) {
            questionText.text = getString(R.string.fourthQuestion)
        }
        return ""
    }

    private fun addAnswer(question: Int, answer: String) {
        answers[question] = answer
    }

    /* This function creates a new results object, gets a fragment to open the results activity, then resets the quiz answers and question number */
    private fun result(questionText: TextView) {
        val quizResultParty: Int = QuizResult(answers).score()

        // Reset quiz questions and answers
        answers.clear()
        questionCount = 1
        questionText.text = getString(R.string.firstQuestion)

        // Something to go to a new activity using the fragment from quiz score
        val intent = Intent(this, QuizResultActivity::class.java)
        intent.putExtra("fragmentToLoad", quizResultParty)
        startActivity(intent)
    }
}