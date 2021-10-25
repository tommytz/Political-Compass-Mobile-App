package com.example.politicalcompass

import android.os.Bundle
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
        setContentView(R.layout.activity_quiz_result)

        val partyResult : Int = intent.extras!!.getInt("fragmentToLoad")

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.resultFragmentContainer, partyFragmentList[partyResult])
        fragmentTransaction.commit()
    }
}
