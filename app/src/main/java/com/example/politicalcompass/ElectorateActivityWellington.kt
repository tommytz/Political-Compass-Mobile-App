package com.example.politicalcompass

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.richpath.RichPath
import com.richpath.RichPathView

class ElectorateActivityWellington : AppCompatActivity() {

    val pathArray = mutableListOf<RichPath>()
    var currentPath: RichPath? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electorate_map_wellington)


        val richPathView: RichPathView = findViewById(R.id.wellington_map)
        richPathView.setOnPathClickListener { richPath ->
            pathArray.add(richPath)
            currentPath = richPath
            richPath.strokeColor = Color.RED

            val resultString = fixMeSomeWords(currentPath!!.name)

            val text: TextView = findViewById(R.id.wellington_map_text_field)
            text.text = resultString
            for (path in pathArray) {
                if (path == richPath) {
                    continue
                } else {
                    path.strokeColor = Color.WHITE
                }
            }
        }


        val nextButton: Button = findViewById(R.id.next_button_wellington_map)
        nextButton.setOnClickListener {
            Toast.makeText(this, "I'll go get your MP's, wait right here", Toast.LENGTH_SHORT)
                .show()
            // need to open the electorate mps here
        }


    }

    fun fixMeSomeWords(unformatted: String): String {
        var resultString: String = ""
        var nameArray = unformatted.split("_")
        for (name in nameArray) {
            var theOutline = name.substring(0, 1)
            val restOfTheOwl = name.substring(1, name.length)
            theOutline = theOutline.uppercase()
            val formattedName = theOutline + restOfTheOwl
            if (resultString.equals("")) {
                resultString += formattedName
            } else {
                resultString += " " + formattedName
            }
        }
        return resultString
    }

}