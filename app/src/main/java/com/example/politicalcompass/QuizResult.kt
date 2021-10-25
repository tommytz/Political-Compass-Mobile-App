package com.example.politicalcompass

class QuizResult(private val answers: HashMap<Int, String>) {
    var vertical = 0
    var horizontal = 0

    val LABOUR: Int = 0
    val NATIONAL: Int = 1
    val GREEN: Int = 2
    val ACT: Int = 3
    val MAORI: Int = 4
    val GARFIELD: Int = 5

    fun score(): Int {
        for (i in answers.keys) {
            val answerString = answers[i]
            if (i == 1) {
                horizontalRight(answerString) //economic right
            }
            if (i == 2) {
                verticalDown(answerString) //libertarian
            }
            if (i == 3) {
                verticalUp(answerString) //authoritarian
            }
            if (i == 4) {
                horizontalLeft(answerString) //economic left
            }
        }
        return partyResult(vertical, horizontal)
    }

    private fun partyResult(verticalScore: Int, horizontalScore: Int): Int {

        if (horizontalScore <= 0 && horizontalScore >= -1) {
            return LABOUR
        }
        if (verticalScore <= -1 && horizontalScore < -1) {
            return GREEN
        }
        if (verticalScore <= 2 && horizontalScore >= 2) {
            return MAORI
        }
        if (verticalScore >= 1 && horizontalScore >= 1) {
            return NATIONAL
        }
        if (verticalScore >= -2 && horizontalScore >= 2) {
            return ACT
        }
        return GARFIELD
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