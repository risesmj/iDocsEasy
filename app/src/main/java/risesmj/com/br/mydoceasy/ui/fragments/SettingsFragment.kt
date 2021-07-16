package risesmj.com.br.mydoceasy.ui.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import risesmj.com.br.mydoceasy.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}