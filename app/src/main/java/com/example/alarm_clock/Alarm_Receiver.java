package com.example.alarm_clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class Alarm_Receiver extends BroadcastReceiver {
    SharedPreferences pref;
    int selectRingtone;
    MediaPlayer music;

    @RequiresApi (api = Build.VERSION_CODES.Q)
    @Override
    public void onReceive(Context context, Intent intent) {
        pref= context.getSharedPreferences("DataPreference",Context.MODE_PRIVATE);
        selectRingtone=pref.getInt("Ringtone",0);
        Vibrator vibrator =(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);

        Toast.makeText(context, "Alarm..! Wake Up..!! ", Toast.LENGTH_SHORT).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if(alarmUri == null){
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }

        switch (selectRingtone){
            case 1:
                music = MediaPlayer.create(context, R.raw.slot_machine_win);
                music.start();
                break;
            case 2:
                music = MediaPlayer.create(context, R.raw.whistle);
                music.start();
                break;
            case 3:
                music = MediaPlayer.create(context, R.raw.serenity);
                music.start();
            case 4:
                music = MediaPlayer.create(context, R.raw.relaxed);
                music.start();
            case 5:
                music = MediaPlayer.create(context, R.raw.nostalgic);
                music.start();
            case 6:
                music = MediaPlayer.create(context, R.raw.messy);
                music.start();
            default:
                Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
                ringtone.play();
        }

    }
}
