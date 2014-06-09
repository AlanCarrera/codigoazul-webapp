package org.itson.bluecode;

import android.app.Application;

import org.itson.bluecode.utils.SettingsReader;

/**
 * Created by Darío Lumbreras on 3/03/14.
 */
public class BluecodeApplication extends Application {

    private static BluecodeApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static synchronized BluecodeApplication getInstance() {
        return sInstance;
    }

    public SettingsReader getSettingsReader() {
        return new SettingsReader(getApplicationContext());
    }

}
