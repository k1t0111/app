package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
        Log.d("xr","MyService...");
    }

    MediaPlayer mediaPlayer;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("xr","MyService onStartCommand...");

        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("xr","MyService onBind...");
        Mybinder binder=new Mybinder();
        return binder;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d("xr","MyService onDestroy...");
        mediaPlayer.stop();
        super.onDestroy();
    }

    public class Mybinder extends Binder {
        public Mybinder() {

        }

        public void todo() {
            Log.d("xr","MyService Mybinder.todo...");
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
            mediaPlayer.start();
        }
    }
}