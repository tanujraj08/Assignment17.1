package com.tanuj.musicplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startPlayButton, stopPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPlayButton = (Button) findViewById(R.id.startPlayButton);
        stopPlayButton = (Button) findViewById(R.id.stopPlayButton);

        startPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MusicPlayerService.class);
                startService(intent);
                showNotification();
            }
        });



        stopPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MusicPlayerService.class);
                stopService(intent);
            }
        });


    }
    public void showNotification(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Service Running")
                .setContentText("Music Playing")
                .setOngoing(true); // On Going


        Intent startIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 101, startIntent, 0);
        builder.setContentIntent(contentIntent);
        Notification notification = builder.build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(101, notification);
    }
}
