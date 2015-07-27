
package com.android.settings.simpleaosp;

import android.content.ContentResolver;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

public class StatusBarSettings extends SettingsPreferenceFragment implements
        OnPreferenceChangeListener {

    // General
    private static String STATUS_BAR_GENERAL_CATEGORY = "status_bar_general_category";
    // Double-tap to sleep
    private static final String DOUBLE_TAP_SLEEP_GESTURE = "double_tap_sleep_gesture";

    // General
    private PreferenceCategory mStatusBarGeneralCategory;
    // Double-tap to sleep
    private SwitchPreference mStatusBarDoubleTapSleepGesture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.status_bar_settings);
	PreferenceScreen prefSet = getPreferenceScreen();

        // General category
        mStatusBarGeneralCategory = (PreferenceCategory) findPreference(STATUS_BAR_GENERAL_CATEGORY);

       // Status bar double-tap to sleep
	mStatusBarDoubleTapSleepGesture = (SwitchPreference) getPreferenceScreen().findPreference(DOUBLE_TAP_SLEEP_GESTURE);
	mStatusBarDoubleTapSleepGesture.setChecked((Settings.System.getInt(getActivity().getApplicationContext().getContentResolver(),
	Settings.System.DOUBLE_TAP_SLEEP_GESTURE, 0) == 1));
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        ContentResolver cr = getActivity().getContentResolver();
	boolean value = (Boolean) objValue;
        if (preference == mStatusBarDoubleTapSleepGesture) {
		Settings.System.putInt(cr,
			Settings.System.DOUBLE_TAP_SLEEP_GESTURE, value ? 1: 0);
		return true;
	}
        return false;
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
 		return super.onPreferenceTreeClick(preferenceScreen, preference);
    	}
}

