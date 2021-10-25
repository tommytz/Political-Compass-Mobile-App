package com.example.politicalcompass;

public class QuizResultActivity {
    var vertical = 0
    var horizontal = 0

    fun score() {
        for (i in answers.keySet()) {
            val s = answers[i]
            if (i == 1) {
                verticalDown(s)
            }
            if (i == 2) {
                horizontalUp(s)
            }
            if (i == 3) {
                horizontalDown(s)
            }
            if (i == 4) {
                verticalUp(s)
            }
        }
    }

    fun horizontalUp(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            horizontal = horizontal + 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            horizontal = horizontal++
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            horizontal = horizontal--
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            horizontal = horizontal - 2
        }
    }

    fun horizontalDown(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            horizontal = horizontal - 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            horizontal = horizontal--
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            horizontal = horizontal++
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            horizontal = horizontal + 2
        }
    }

    fun verticalUp(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            vertical = vertical + 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            vertical = vertical++
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            vertical = vertical--
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            vertical = vertical - 2
        }
    }

    fun verticalDown(answer: String?) {
        if (answer.equals("Strongly Agree", ignoreCase = true)) {
            vertical = vertical - 2
        }
        if (answer.equals("Agree", ignoreCase = true)) {
            vertical = vertical--
        }
        if (answer.equals("Disagree", ignoreCase = true)) {
            vertical = vertical++
        }
        if (answer.equals("Strongly Disagree", ignoreCase = true)) {
            vertical = vertical + 2
        }
    }
}
}
