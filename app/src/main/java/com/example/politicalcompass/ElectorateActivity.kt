package com.example.politicalcompass

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.richpath.RichPath
import com.richpath.RichPathView

class ElectorateActivity : AppCompatActivity() {

    val pathArray = mutableListOf<RichPath>()
    var currentPath: RichPath? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electorate_map)


        val richPathView: RichPathView = findViewById(R.id.nz_map)
        richPathView.setOnPathClickListener { richPath ->
            pathArray.add(richPath)
            currentPath = richPath
            richPath.strokeColor = Color.RED

            val resultString = fixMeSomeWords(currentPath!!.name)

            val text: TextView = findViewById(R.id.nz_map_text_field)
            text.text = resultString
            for (path in pathArray) {
                if (path == richPath) {
                    continue
                } else {
                    path.strokeColor = Color.WHITE
                }
            }
        }

        val nextButton: Button = findViewById(R.id.next_button_map)
        nextButton.setOnClickListener {
            if (currentPath != null && currentPath!!.name.equals("north_island")) {
                val intent = Intent(this, ElectorateActivityNorth::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "That ain't it", Toast.LENGTH_SHORT).show()
            }
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