package com.example.politicalcompass

import androidx.fragment.app.Fragment

class QuizResult(private val answers: HashMap<Int, String>) {
    private val partyFragmentList = listOf<Fragment>(LabourPartyInfo(), NationalPartyInfo(), GreenPartyInfo(), ACTInfo(), MaoriPartyInfo())
    private var vertical = 0
    private var horizontal = 0

   fun score() : Fragment {
        for (i in answers.keys) {
            val answer = answers[i]
            if (i == 1) {
                verticalDown(answer)
            }
            if (i == 2) {
                horizontalUp(answer)
            }
            if (i == 3) {
                horizontalDown(answer)
            }
            if (i == 4) {
                verticalUp(answer)
            }
        }
       return partyResult(vertical, horizontal)
       // This is the part that needs work
    }

    private fun partyResult(verticalScore : Int, horizontalScore : Int) : Fragment {
        return partyFragmentList[0] // Placeholder until we put logic in...
    }

    private fun horizontalUp(answer: String?) {
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

    private fun horizontalDown(answer: String?) {
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

    private fun verticalUp(answer: String?) {
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

    private fun verticalDown(answer: String?) {
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