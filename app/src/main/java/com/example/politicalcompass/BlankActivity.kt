package com.example.politicalcompass

import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BlankActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale()
        supportActionBar?.hide()
        setContentView(R.layout.blank_layout)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, SettingsFragment())
            .commit()


//        val themeArray = resources.getStringArray(R.array.theme_values)
//        val languageArray = resources.getStringArray(R.array.language_values)
//
//        val themePreference = getPreference("theme_radio")


    }

    fun setLocale(language: String) {
        val locale: Locale = Locale(language)
        Locale.setDefault(locale)
        val config: Configuration = Configuration()
        val resources = baseContext.resources
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
        val sharedPrefEdit: SharedPreferences.Editor =
            getSharedPreferences("settings", MODE_PRIVATE).edit()
        sharedPrefEdit.putString("language_select", language)
        sharedPrefEdit.apply()

    }

    fun loadLocale() {
        val prefs: SharedPreferences = getSharedPreferences("settings", Activity.MODE_PRIVATE)
        val language: String = prefs.getString("language_select", "").toString()
        setLocale(language)
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

