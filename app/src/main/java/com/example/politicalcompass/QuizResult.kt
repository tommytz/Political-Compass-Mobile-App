package com.example.politicalcompass

class QuizResult(private val answers: HashMap<Int, String>) {
    var vertical = 0
    var horizontal = 0


    fun score() {
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

    private fun partyResult(verticalScore : Int, horizontalScore : Int) : Fragment {
        return partyFragmentList[0] // Placeholder until we put logic in...
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