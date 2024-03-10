package com.example.alarm_clock;

//import android.support.v7.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class Set_Alarm extends AppCompatActivity {
    Context context = this;
    TimePicker timePicker;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();

        setContentView(R.layout.activity_set_alarm);

        timePicker = (TimePicker) findViewById(R.id.set_alarm);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.set_alarm);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.alarm:
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(),history.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        TextView ringtone = findViewById(R.id.ringtone);

        ringtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Set_Alarm.this, Ringtones.class);
                startActivity(i);
            }
        });
    }

    public void OnToggleClicked(View v){
        long time;
        if(((ToggleButton) v).isChecked() ){
            Toast.makeText(Set_Alarm.this, "Alarm On", Toast.LENGTH_SHORT).show();
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

            Intent i = new Intent(this, Alarm_Receiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_IMMUTABLE);

            time = (calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
            if(System.currentTimeMillis() > time){
                if(Calendar.AM_PM == 0){
                    time = time + (1000 * 60 * 60 * 12);
                }
                else {
                    time = time + (1000 * 60 * 60 * 24);
                }
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);
        }
        else {

            alarmManager.cancel(pendingIntent);
            Toast.makeText(Set_Alarm.this, "Alarm Off", Toast.LENGTH_SHORT).show();
        }
    }
}