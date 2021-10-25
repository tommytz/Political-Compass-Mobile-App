package com.example.politicalcompass

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PolicyInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.policy_info_activity)



        val text : TextView = findViewById(R.id.test)
        text.setText(getIntent().getStringExtra("message"))
    }

}