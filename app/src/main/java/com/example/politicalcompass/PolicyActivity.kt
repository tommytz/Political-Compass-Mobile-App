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
                putExtra("message", "environment")
            }
            startActivity(intent)
        }

        val housingButton : Button = findViewById(R.id.housingButton)
        housingButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "housing")
            }
            startActivity(intent)
        }

        val educationButton : Button = findViewById(R.id.educationButton)
        educationButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "education")
            }
            startActivity(intent)
        }

        val economyButton : Button = findViewById(R.id.economyButton)
        economyButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "economy")
            }
            startActivity(intent)
        }

        val healthButton : Button = findViewById(R.id.healthButton)
        healthButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "health")
            }
            startActivity(intent)
        }

        val infrastructureButton : Button = findViewById(R.id.infrastructureButton)
        infrastructureButton.setOnClickListener {
            val intent = Intent(this, PolicyInfoActivity::class.java).apply {
                putExtra("message", "infrastructure")
            }
            startActivity(intent)
        }


    }
}