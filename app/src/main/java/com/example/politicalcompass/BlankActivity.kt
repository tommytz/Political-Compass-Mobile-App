package com.example.politicalcompass

import android.content.res.Configuration
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BlankActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blank_layout)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, SettingsFragment())
            .commit()

//        val themeArray = resources.getStringArray(R.array.theme_values)
//        val languageArray = resources.getStringArray(R.array.language_values)
//
//        val themePreference = getPreference("theme_radio")


    }

//    companion object {
//        public var dLocale: Locale? = null
//    }
//
//    init {
//        updateConfig(this)
//    }
//
//    fun updateConfig(wrapper: ContextThemeWrapper) {
//        if (dLocale == Locale("")) // Do nothing if dLocale is null
//            return
//
//        Locale.setDefault(dLocale)
//        val configuration = Configuration()
//        configuration.setLocale(dLocale)
//        wrapper.applyOverrideConfiguration(configuration)
//    }
}

