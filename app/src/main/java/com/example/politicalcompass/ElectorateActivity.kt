package com.example.politicalcompass

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
            if (currentPath!!.name.equals("north_island")) {
                val intent = Intent(this, ElectorateActivityNorth::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "That ain't it", Toast.LENGTH_SHORT).show()
            }
        }


    }

}