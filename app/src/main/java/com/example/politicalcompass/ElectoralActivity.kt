package com.example.politicalcompass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import com.richpath.RichPath
import com.richpath.RichPathView

class ElectoralActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electoral_map_one)


        val richPathView: RichPathView = findViewById<RichPathView>(R.id.nz_map)

        richPathView.setOnPathClickListener { richPath ->
            if (richPath.name == "wellington_region") {
                if (richPath.strokeColor == 2){
                    richPath.strokeColor = 3
                } else {
                    richPath.strokeColor = 2
                }

            }
        }


    }
}