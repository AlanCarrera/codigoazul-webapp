package org.itson.bluecode.activities;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.itson.bluecode.BluecodeApplication;
import org.itson.bluecode.R;
import org.itson.bluecode.services.AlarmService;
import org.itson.bluecode.utils.SettingsReader;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class BluecodeActivity extends ActionBarActivity {

    static final String TAG = "BluecodeActivity";

    private static final String BLUETOOTH_DEVICE_MAC = "00:06:66:49:58:A8";
    private static final UUID BLUETOOTH_DEVICE_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    private static final int REQUEST_ENABLE_BLUETOOTH = 1;

    private Context mContext;
    private AlarmService mAlarmService;

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothSocket mBluetoothSocket;
    private OutputStream mBluetoothOutput;

    private ServiceConnection mAlarmServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mAlarmService = ((AlarmService.AlarmServiceBinder) binder).getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mAlarmService = null;
        }
    };

    @Override
    public void onAttachedToWindow() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluecode);
        getSupportActionBar().hide();

        mContext = getApplicationContext();

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String zone = extras.getString("zone");
        String role = extras.getString("role");

        ((TextView) findViewById(R.id.name)).setText(name);
        ((TextView) findViewById(R.id.zone)).setText(zone);
        ((TextView) findViewById(R.id.role)).setText(role);

        SettingsReader settings = BluecodeApplication.getInstance().getSettingsReader();

        if (settings.isAlarmEnabled()) {
            startAlarm();
        }

        if (settings.isArduinoEnabled()) {
            startBluetooth();
        }
    }

    @Override
    protected void onDestroy() {
        if (mAlarmService != null) {
            mAlarmService.stop();
            unbindService(mAlarmServiceConnection);
        }

        if (mBluetoothDevice != null) {
            try {
                mBluetoothOutput.write("d".getBytes());
                mBluetoothOutput.close();
                mBluetoothSocket.close();
            } catch (IOException e) {
                // No hace nada.
            }
        }

        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BLUETOOTH && resultCode == RESULT_OK) {
            findBluetoothDevice();
        }
    }

    @Override
    public void onBackPressed() {
        // Evita ir atras.
    }

    public void onClickAccept(View button) {
        finish();
    }

    private void startBluetooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!mBluetoothAdapter.isEnabled()) {
            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQUEST_ENABLE_BLUETOOTH);
            return;
        }

        findBluetoothDevice();
    }

    private void startAlarm() {
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        bindService(new Intent(mContext, AlarmService.class), mAlarmServiceConnection, BIND_AUTO_CREATE);
    }

    private void findBluetoothDevice() {
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(BLUETOOTH_DEVICE_MAC);
        if (device != null) {
            setupBluetoothDevice(device);
        }
    }

    private void setupBluetoothDevice(BluetoothDevice device) {
        try {
            mBluetoothDevice = device;
            mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(BLUETOOTH_DEVICE_UUID);
            mBluetoothSocket.connect();
            mBluetoothOutput = mBluetoothSocket.getOutputStream();
            mBluetoothOutput.write("s".getBytes());
        } catch (IOException e) {
            Log.v(TAG, "No se pudo conectar al dispositivo Bluetooth");
        }
    }

}
