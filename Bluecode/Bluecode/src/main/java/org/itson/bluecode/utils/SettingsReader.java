package org.itson.bluecode.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Darío Lumbreras on 3/03/14.
 */
public class SettingsReader {

    private static final String PROPERTY_ADDRESS = "address";
    private static final String PROPERTY_PORT = "port";
    private static final String PROPERTY_ENABLE_ARDUINO = "enable_arduino";
    private static final String PROPERTY_ENABLE_ALARM = "enable_alarm";

    private String address;
    private int port;
    private boolean arduino;
    private boolean alarm;

    public SettingsReader(Context context) {
        SharedPreferences prefs
                = PreferenceManager.getDefaultSharedPreferences(context);

        address = prefs.getString(PROPERTY_ADDRESS, "");

        try {
            port = Integer.parseInt(prefs.getString(PROPERTY_PORT, ""));
        } catch (NumberFormatException e) {
            port = 0;
        }

        arduino = prefs.getBoolean(PROPERTY_ENABLE_ARDUINO, false);
        alarm = prefs.getBoolean(PROPERTY_ENABLE_ALARM, false);
    }

    public boolean isAlarmEnabled() {
        return alarm;
    }

    public boolean isArduinoEnabled() { return arduino; }

    public String getServerUrl() {
        return "http://" + address + ":" + port;
    }

}
