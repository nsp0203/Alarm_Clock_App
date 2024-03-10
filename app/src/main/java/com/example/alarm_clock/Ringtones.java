package com.example.alarm_clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Ringtones extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();

        setContentView(R.layout.activity_ringtones);



        DataClass[] classes=new DataClass[]{
                new DataClass("Slot Machine Win"),
                new DataClass("Whistle"),
                new DataClass("Serenity"),
                new DataClass("Relaxed"),
                new DataClass("Nostalgic"),
                new DataClass("Messy")
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(classes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
       // adapter.setOnItemClickListener((Adapter.OnItemClickListener) this);

    }

    public void OnItemClick(DataClass item){
        String selectedMusic = item.getMusic();
    }
    @Override
    protected void onPause() {
        super.onPause();
       // music.release();
        finish();
    }
}