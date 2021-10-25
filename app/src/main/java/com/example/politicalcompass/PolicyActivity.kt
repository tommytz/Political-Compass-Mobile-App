package com.example.politicalcompass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class PolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.policy_landing_page_activity)

        val environmentButton : Button = findViewById(R.id.environmentButton)
        environmentButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "environment pressed")
            }
            startActivity(intent)
        }

        val housingButton : Button = findViewById(R.id.educationButton)
        housingButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "housing pressed")
            }
            startActivity(intent)
        }
    }
}