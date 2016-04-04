package com.android.settings.cardinal;

import com.android.internal.logging.MetricsLogger;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.SwitchPreference;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class ButtonsSettings extends SettingsPreferenceFragment implements
        OnPreferenceChangeListener {

		// private variables here
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.cardinal_settings_buttons);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {

		// preference changes here
        return false;
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsLogger.BUTTONS_SETTINGS;
    }
}