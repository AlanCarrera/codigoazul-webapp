package org.itson.bluecode.activities;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.itson.bluecode.BluecodeApplication;
import org.itson.bluecode.R;
import org.itson.bluecode.services.ConnectionService;
import org.itson.bluecode.utils.SettingsReader;

public class StartActivity extends ActionBarActivity {

    private Context mContext;
    private SettingsReader mReader;

    private WifiManager mWifiManager;
    private WifiInfo mWifiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        mContext = getApplicationContext();
        mReader  = BluecodeApplication.getInstance().getSettingsReader();

        mWifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        mWifiInfo = mWifiManager.getConnectionInfo();

        ((TextView) findViewById(R.id.mac)).setText(mWifiInfo.getMacAddress());

        startService(new Intent(mContext, ConnectionService.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(mContext, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
