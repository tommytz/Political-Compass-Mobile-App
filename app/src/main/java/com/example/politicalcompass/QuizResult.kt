package com.example.politicalcompass

import androidx.fragment.app.Fragment

class QuizResult(private val answers: HashMap<Int, String>) {
    var vertical = 0
    var horizontal = 0

    val LABOUR: Int = 0
    val NATIONAL: Int = 1
    val GREEN: Int = 2
    val ACT: Int = 3
    val MAORI: Int = 4

    fun score() : Int {
        for (i in answers.keys) {
            val s = answers[i]
            if (i == 1) {
                horizontalRight(s) //economic right
                verticalDown(s) //libertarian
            }
            if (i == 2) {
                verticalDown(s) //libertarian
                horizontalLeft(s) //economic left

            }
            if (i == 3) {
                horizontalRight(s) //economic right
                verticalUp(s) //authoritarian
            }
            if (i == 4) {
                horizontalLeft(s) //economic left
                verticalUp(s) //authoritarian
            }
        }
        return partyResult(vertical, horizontal)
    }

    private fun partyResult(verticalScore : Int, horizontalScore : Int) : Int {

        if (horizontalScore <= -4 && horizontalScore >= 2) {
            return LABOUR
        }
        if (verticalScore >= 5 && horizontalScore <= -4){
            return GREEN
        }
        if (verticalScore >= 4 && horizontalScore <= -5){
            return MAORI
        }
        if (verticalScore >= -2 && horizontalScore >= 3){
            return NATIONAL
        }
        if (horizontalScore <= -2 && horizontalScore >= 6){
            return NATIONAL
        }
        if (verticalScore >= -3 && horizontalScore >= 6){
            return ACT
        }

    }

    fun horizontalRight(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            horizontal += 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            horizontal++
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            horizontal--
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            horizontal -= 2
        }
    }

    fun horizontalLeft(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            horizontal -= 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            horizontal--
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            horizontal++
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            horizontal += 2
        }
    }

    fun verticalUp(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            vertical += 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            vertical++
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            vertical--
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            vertical -= 2
        }
    }

    fun verticalDown(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            vertical -= 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            vertical--
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            vertical++
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            vertical += 2
        }
    }


}