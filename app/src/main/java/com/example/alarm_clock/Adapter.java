package com.example.alarm_clock;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    DataClass[] list_data;
    MediaPlayer music;
    SharedPreferences preferences;
    Context context;
    Boolean running=false;

    public Adapter(DataClass[] list_data){
        this.list_data = list_data;
    }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        preferences=context.getSharedPreferences("DataPreference",Context.MODE_PRIVATE);
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.items, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final DataClass classes = list_data[position];
        holder.textView.setText(list_data[position].getMusic());
        int DataPosition=position;
        SharedPreferences.Editor edit=preferences.edit();
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (DataPosition){
                    case 0:
                        if(running==true){
                            music.release();
                            music = MediaPlayer.create(v.getContext(), R.raw.slot_machine_win);
                            music.start();
                            running=true;
                            edit.putInt("Ringtone",1).apply();
                        }else{
                            music = MediaPlayer.create(v.getContext(), R.raw.slot_machine_win);
                            music.start();
                            running=true;
                            edit.putInt("Ringtone",1).apply();
                        }

                        break;
                    case 1:
                        if(running==true) {
                            music.release();
                            music = MediaPlayer.create(v.getContext(), R.raw.whistle);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 2).apply();
                        }else{
                            music = MediaPlayer.create(v.getContext(), R.raw.whistle);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 2).apply();
                        }

                        break;
                    case 2:
                        if(running==true) {
                            music.release();
                            music = MediaPlayer.create(v.getContext(), R.raw.serenity);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 3).apply();
                        }else{
                            music = MediaPlayer.create(v.getContext(), R.raw.serenity);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 3).apply();
                        }
                        break;
                    case 3:
                        if(running==true) {
                            music.release();
                            music = MediaPlayer.create(v.getContext(), R.raw.relaxed);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 4).apply();
                        }else{
                            music = MediaPlayer.create(v.getContext(), R.raw.relaxed);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 4).apply();
                        }
                        break;
                    case 4:
                        if(running==true) {
                            music.release();
                            music = MediaPlayer.create(v.getContext(), R.raw.nostalgic);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 5).apply();
                        }else{
                            music = MediaPlayer.create(v.getContext(), R.raw.nostalgic);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 5).apply();
                        }
                        break;
                    case 5:
                        if(running==true){
                            music.release();
                            music = MediaPlayer.create(v.getContext(), R.raw.messy);
                            music.start();
                            running=true;
                            edit.putInt("Ringtone",6).apply();
                        }else {
                            music = MediaPlayer.create(v.getContext(), R.raw.messy);
                            music.start();
                            running = true;
                            edit.putInt("Ringtone", 6).apply();
                        }
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Integer len =list_data.length;
        return len;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.items);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout);
        }
    }
}
