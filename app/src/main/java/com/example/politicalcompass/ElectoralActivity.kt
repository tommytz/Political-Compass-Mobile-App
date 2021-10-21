package com.example.politicalcompass

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import com.richpath.RichPath
import com.richpath.RichPathView

class ElectoralActivity : AppCompatActivity() {

    val pathArray  = mutableListOf<RichPath>()
    var currentPath : RichPath? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electoral_map_one)


        val richPathView: RichPathView = findViewById<RichPathView>(R.id.nz_map)
        richPathView.setOnPathClickListener { richPath ->
            pathArray.add(richPath)
            currentPath = richPath
            if (richPath.name == "north_island") {
                richPath.strokeColor = Color.RED
            } else if (richPath.name == "south_island") {
                richPath.strokeColor = Color.RED
            }
            for (path in pathArray) {
                if (path == richPath){
                    continue
                } else {
                    path.strokeColor = Color.WHITE
                }
            }
        }


    }
}