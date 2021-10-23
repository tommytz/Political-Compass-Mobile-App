package com.example.politicalcompass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BlankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blank_layout)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, SettingsFragment())
            .commit()
    }
}