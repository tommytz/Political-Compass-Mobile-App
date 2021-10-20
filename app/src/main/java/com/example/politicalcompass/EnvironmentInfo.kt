package com.example.politicalcompass

import android.os.Bundle
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