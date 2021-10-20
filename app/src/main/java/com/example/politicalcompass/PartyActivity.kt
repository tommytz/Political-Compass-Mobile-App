package com.example.politicalcompass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class PartyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.party_activity)

        val partyList = listOf<String>("Labour", "National", "Green", "ACT", "Maori")

        var info : TextView = findViewById<TextView>(R.id.textView)
        info.text = "Test"

        val partyMenu : AutoCompleteTextView = findViewById(R.id.menu)
        val parties = resources.getStringArray(R.array.parties)
        val adapter = ArrayAdapter(this, R.layout.list_item, parties)
        partyMenu.setAdapter(adapter)

        partyMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                info.text = partyList[position]
                info.invalidate()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}