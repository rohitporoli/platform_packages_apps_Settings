package com.android.settings.cardinal;

import com.android.internal.logging.MetricsLogger;

import android.os.Bundle;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CardinalSettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.cardinal_settings);
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsLogger.CARDINAL_SETTINGS;
    }
}