package com.example.politicalcompass

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class QuizResultActivity : AppCompatActivity() {
    private val partyFragmentList = listOf<Fragment>(
        LabourPartyInfo(),
        NationalPartyInfo(),
        GreenPartyInfo(),
        ACTInfo(),
        MaoriPartyInfo(),
        GarfieldInfo()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_quiz_result)

        val partyResult: Int = intent.extras!!.getInt("fragmentToLoad")

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.resultFragmentContainer, partyFragmentList[partyResult])
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun restartQuiz(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}
