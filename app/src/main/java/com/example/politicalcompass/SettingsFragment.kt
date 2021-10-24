package com.example.politicalcompass

import android.os.Bundle
import androidx.preference.DropDownPreference
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
//import com.example.politicalcompass.BlankActivity.Companion.dLocale
import java.util.*

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val themeArray = resources.getStringArray(R.array.theme_values)
        val languageArray = resources.getStringArray(R.array.language_values)
        val preferences = preferenceManager

        val themePreference = preferences.findPreference<ListPreference>("theme_radio")
        val languagePreference = preferences.findPreference<DropDownPreference>("language_dropdown")

        var change = ""
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context)
        val language = sharedPreferences.getString("language", "bak")
        if (language == "English") {
            change = "english"
        } else if (language == "Te Reo Maori") {
            change = "te_reo_maori"
        } else {
            change = ""
        }


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
}