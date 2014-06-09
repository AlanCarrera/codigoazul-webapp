package org.itson.bluecode.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import org.itson.bluecode.R;

public class AlarmService extends Service {

    public static final String PLAY_ACTION = "org.itson.bluecode.PLAY_ACTION";
    public static final String STOP_ACTION = "org.itson.bluecode.STOP_ACTION";

    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;
    private int mMaxVolume;

    private final AlarmServiceBinder mBinder = new AlarmServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        mMaxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();
            if (PLAY_ACTION.equals(action)) {
                play();
            } else if (STOP_ACTION.equals(action)) {
                stop();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDestroy();
    }

    public void play() {
        if (mAudioManager != null && mMediaPlayer != null) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mMaxVolume, 0);
            mMediaPlayer.start();
        }
    }

    public void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.pause();
            mMediaPlayer.seekTo(0);
        }
    }

    public class AlarmServiceBinder extends Binder {
        public AlarmService getService() {
            return AlarmService.this;
        }
    }

}
