package com.example.politicalcompass

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat.recreate
import androidx.preference.DropDownPreference
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
//import com.example.politicalcompass.BlankActivity.Companion.dLocale
import java.util.*

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val preferenceManager = preferenceManager
        var themePreference = preferenceManager.findPreference<ListPreference>("theme_radio")
        var languagePreference =
            preferenceManager.findPreference<DropDownPreference>("language_dropdown")
//        loadLocale()
        languagePreference!!.setOnPreferenceChangeListener { preference, newValue ->
            BlankActivity().setLocale(newValue as String) //apparently this isn't the right way to do it
            recreate(BlankActivity())
            //use the no sound video to add methods here to change the language
            return@setOnPreferenceChangeListener true
        }


//        val themeArray = resources.getStringArray(R.array.theme_values)
//        val languageArray = resources.getStringArray(R.array.language_values)
//        val preferences = preferenceManager
//
//        val themePreference = preferences.findPreference<ListPreference>("theme_radio")
//        val languagePreference = preferences.findPreference<DropDownPreference>("language_dropdown")
//
//        var change = ""
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context)
//        val language = sharedPreferences.getString("language", "bak")
//        if (language == "English") {
//            change = "english"
//        } else if (language == "Te Reo Maori") {
//            change = "te_reo_maori"
//        } else {
//            change = ""
//        }


//        BlankActivity.dLocale = Locale(change)
//
//        themePreference!!.setOnPreferenceChangeListener { preference, newValue ->
//            dLocale = sharedPreferences.getString(newValue, "bak")
//            Locale.CHINA
//            preference.setDefaultValue(newValue)
//        }
//        themePreference.setOnPreferenceChangeListener( preferenceChangeListen : OnPreferenceChangeListern() {
//
//        })
//
//        language_preference.setOnPreferenceChangeListener(object : OnPreferenceChangeListener() {
//            fun onPreferenceChanged(preference: Preference?, newValue: Any?): Boolean {
//                shareprefs.putString("language_preference", newValue as String?)
//                makeVoiceData()
//            }
//        })
    }

//    fun setLocale(language : String) {
//        val locale : Locale = Locale(language)
//        Locale.setDefault(locale)
//        val config : Configuration = Configuration()
//        config.locale = locale
//        BlankActivity().baseContext.resources.updateConfiguration(config,  BlankActivity().baseContext.resources.displayMetrics)
//        val sharedPrefEdit : SharedPreferences.Editor = BlankActivity().getSharedPreferences("settings", MODE_PRIVATE).edit()
//        sharedPrefEdit.putString("language_select", language)
//        sharedPrefEdit.apply()
//
//    }
//
//    fun loadLocale() {
//        val prefs : SharedPreferences = BlankActivity().getSharedPreferences("settings", Activity.MODE_PRIVATE)
//        val language : String = prefs.getString("language_select", "").toString()
//        setLocale(language)
//    }
}