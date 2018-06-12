package com.tanuj.musicplayer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;


public class MusicPlayerService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.aksar2song);
    }

    // Override Service Start Commoand Method.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // On Service Start Play Music
        mediaPlayer.start();
        return START_STICKY;
    }

    // OVerride Destory Service.
    @Override
    public void onDestroy() {
        super.onDestroy();

        // If Music Playing Pause the music
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

        // Else Release Music Player Object and Destroy
        mediaPlayer.release();
    }
}
