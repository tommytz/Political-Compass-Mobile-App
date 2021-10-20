package com.example.politicalcompass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class PartyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.party_activity)

        fun replaceFragment(fragment : Fragment){
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
            fragmentTransaction.commit()
        }

        val partyList = listOf<String>("Labour", "National", "Green", "ACT", "Maori")
        val output : TextView = findViewById(R.id.textView)

        val partyMenu : AutoCompleteTextView = findViewById(R.id.menu)
        val parties = resources.getStringArray(R.array.parties)
        val adapter = ArrayAdapter(this, R.layout.list_item, parties)
        partyMenu.setAdapter(adapter)

        partyMenu.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                l: Long -> if (position == 0){
                    replaceFragment(LabourPartyInfo())
            } else if (position == 1){ replaceFragment(NationalPartyInfo())
                    }
        }
    }
}


