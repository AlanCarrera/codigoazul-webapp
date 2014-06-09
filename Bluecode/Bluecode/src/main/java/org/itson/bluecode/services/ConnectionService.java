package org.itson.bluecode.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.socketio.Acknowledge;
import com.koushikdutta.async.http.socketio.ConnectCallback;
import com.koushikdutta.async.http.socketio.DisconnectCallback;
import com.koushikdutta.async.http.socketio.EventCallback;
import com.koushikdutta.async.http.socketio.ExceptionCallback;
import com.koushikdutta.async.http.socketio.SocketIOClient;

import org.itson.bluecode.BluecodeApplication;
import org.itson.bluecode.activities.BluecodeActivity;
import org.itson.bluecode.activities.StartActivity;
import org.itson.bluecode.utils.SettingsReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class ConnectionService extends Service implements ConnectCallback {

    private static final String TAG = "ConnectionService";

    private static final int NOTIFICATION_CONNECTING = 1001;
    private static final int NOTIFICATION_CONNECTED = 1002;
    private static final int NOTIFICATION_ERROR = 1003;

    private Context mContext;
    private NotificationManager mNotificationManager;

    private Future<SocketIOClient> mFuture;
    private SocketIOClient mSocketClient;

    private WifiManager mWifiManager;
    private WifiInfo mWifiInfo;

    private int mCurrentType = NOTIFICATION_CONNECTING;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        mWifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        mWifiInfo = mWifiManager.getConnectionInfo();

        showNotification(NOTIFICATION_CONNECTING);
        startWebSocketConnection();
    }

    @Override
    public void onDestroy() {
        if (mSocketClient != null) {
            mSocketClient.disconnect();
            mSocketClient = null;
        }

        if (mFuture != null) {
            mFuture.cancel();
            mFuture = null;
        }

        if (mNotificationManager != null) {
            mNotificationManager.cancel(mCurrentType);
        }

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onConnectCompleted(Exception e, SocketIOClient client) {
        if (e == null) {
            onOpen(client);
        } else {
            onError();
        }
    }

    private void onOpen(SocketIOClient client) {
        showNotification(NOTIFICATION_CONNECTED);
        setupWebSocket(client);
    }

    private void onBluecode(Bundle params) {
        SettingsReader settings = BluecodeApplication.getInstance().getSettingsReader();

        if (settings.isAlarmEnabled()) {
            startAlarmService();
        }

        startBluecodeActivity(params);
    }

    private void onError() {
        restartWebSocket();
    }

    private void startWebSocketConnection() {
        SettingsReader settings = BluecodeApplication.getInstance().getSettingsReader();
        mFuture = SocketIOClient.connect(AsyncHttpClient.getDefaultInstance(), settings.getServerUrl(), this);
    }

    private void startBluecodeActivity(Bundle params) {
        Intent intent = new Intent(mContext, BluecodeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void startAlarmService() {
        Intent intent = new Intent(mContext, AlarmService.class);
        intent.setAction(AlarmService.PLAY_ACTION);
        startService(intent);
    }

    private void showNotification(int type) {
        Intent intent = new Intent(mContext, StartActivity.class);
        PendingIntent pending = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext)
                .setOngoing(true)
                .setAutoCancel(false)
                .setContentIntent(pending)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setContentTitle("Bluecode");

        switch (type) {
            case NOTIFICATION_CONNECTING:
                builder.setContentText("Conectando al servidor...");
                break;
            case NOTIFICATION_CONNECTED:
                builder.setContentText("Se ha establecido la conexión");
                break;
            case NOTIFICATION_ERROR:
                builder.setContentText("Se ha cerrado la conexión. Reiniciando.");
                break;
        }

        mNotificationManager.cancel(mCurrentType);
        mNotificationManager.notify(type, builder.build());

        mCurrentType = type;
    }

    private void restartWebSocket() {
        if (mSocketClient == null || !mSocketClient.isConnected()) {
            showNotification(NOTIFICATION_ERROR);
            startWebSocketConnection();
        }
    }

    private void setupWebSocket(SocketIOClient client) {
        mSocketClient = client;
        mSocketClient.emit("setup", getSetupValues());
        mSocketClient.on("bluecode", new EventCallback() {
            @Override
            public void onEvent(JSONArray array, Acknowledge acknowledge) {
                Bundle params = new Bundle();

                if (array.length() > 0) {
                    JSONObject object = array.optJSONObject(0);
                    Iterator<String> keys = object.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        String value = object.optString(key);
                        params.putString(key, value);
                    }
                }

                onBluecode(params);
            }
        });
        mSocketClient.setDisconnectCallback(new DisconnectCallback() {
            @Override
            public void onDisconnect(Exception e) {
                if (e != null) {
                    onError();
                }
            }
        });
        mSocketClient.setExceptionCallback(new ExceptionCallback() {
            @Override
            public void onException(Exception e) {
                if (e != null) {
                    onError();
                }
            }
        });
    }

    private JSONArray getSetupValues() {
        JSONArray array = new JSONArray();
        array.put(mWifiInfo.getMacAddress());
        return array;
    }

}
