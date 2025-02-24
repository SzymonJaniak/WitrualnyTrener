package com.example.wirtualnytrener;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class StopwatchFragment extends Fragment implements View.OnClickListener {
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
     runTimer(layout);
      Button startButton = layout.findViewById(R.id.start_button);
     startButton.setOnClickListener(this);

        Button stopButton = layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);

        Button resetButton = layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);


        return layout;
    }
    private void onClickStart() {
        running = true;
    }

    private void onClickStop() {
        running = false;
    }

    private void onClickReset() {
        running = false;
        seconds = 0;
    }

    private void runTimer(View view){
        TextView timeView = view.findViewById(R.id.time_view);

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
}

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.start_button){
            onClickStart();
        } else if (v.getId() == R.id.stop_button) {
            onClickStop();

        } else if (v.getId() == R.id.reset_button) {
            onClickReset();

        }
    }
}