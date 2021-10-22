package com.example.politicalcompass

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.richpath.RichPath
import com.richpath.RichPathView

class ElectorateActivityNorth : AppCompatActivity() {

    val pathArray = mutableListOf<RichPath>()
    var currentPath: RichPath? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electorate_map_north)


        val richPathView: RichPathView = findViewById(R.id.nz_map)
        richPathView.setOnPathClickListener { richPath ->
            pathArray.add(richPath)
            currentPath = richPath
            richPath.strokeColor = Color.RED
            for (path in pathArray) {
                if (path == richPath) {
                    continue
                } else {
                    path.strokeColor = Color.WHITE
                }
            }
        }


        val nextButton: Button = findViewById(R.id.next_button_north_map)
        nextButton.setOnClickListener {
            if (currentPath!!.name.equals("wellington")) {
                val intent = Intent(this, ElectorateActivityWellington::class.java)
                startActivity(intent)
            }
        }


    }

}