package com.example.politicalcompass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class PartyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.party_activity)

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
                l: Long -> output.text = partyList[position] + " is selected!"
        }
    }
}


