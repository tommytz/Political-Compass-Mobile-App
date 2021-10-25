package com.example.politicalcompass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import java.util.*

class PartyActivity : AppCompatActivity() {
    private val partyFragmentList = listOf<Fragment>(LabourPartyInfo(), NationalPartyInfo(), GreenPartyInfo(), ACTInfo(), MaoriPartyInfo())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.party_activity)

        // Code to set up the dropdown menu and the on click listener
        val partyMenu : AutoCompleteTextView = findViewById(R.id.menu)
        val parties = resources.getStringArray(R.array.parties)
        val adapter = ArrayAdapter(this, R.layout.list_item, parties)
        partyMenu.setAdapter(adapter)
        partyMenu.onItemClickListener = AdapterView.OnItemClickListener{_: AdapterView<*>?, _: View?, position: Int, _: Long -> replacePartyFragment(position)}
    }

    /* This function takes the input from the menu on click listener and uses it to
       change fragments in the view so that different party info can be displayed. */
    private fun replacePartyFragment(position : Int){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.partyFragments, partyFragmentList[position])
        fragmentTransaction.commit()
    }
}
