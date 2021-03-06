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

	 private static final String VOLUME_ROCKER_WAKE = "volume_rocker_wake";
	 
	 private SwitchPreference mVolumeRockerWake;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.cardinal_settings_buttons);
		
		mVolumeRockerWake = (SwitchPreference) findPreference(VOLUME_ROCKER_WAKE);
        mVolumeRockerWake.setOnPreferenceChangeListener(this);
        int volumeRockerWake = Settings.System.getInt(getContentResolver(),
                VOLUME_ROCKER_WAKE, 0);
        mVolumeRockerWake.setChecked(volumeRockerWake != 0);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {

		 if (preference == mVolumeRockerWake) {
            boolean value = (Boolean) objValue;
            Settings.System.putInt(getContentResolver(), VOLUME_ROCKER_WAKE,
                    value ? 1 : 0);
            return true;
        }
        return false;
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsLogger.BUTTONS_SETTINGS;
    }
}