package org.itson.bluecode.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import org.itson.bluecode.R;

@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayShowHomeEnabled(false);
        addPreferencesFromResource(R.xml.settings);
    }

}
