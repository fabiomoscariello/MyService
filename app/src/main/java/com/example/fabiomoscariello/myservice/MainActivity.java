package com.example.fabiomoscariello.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button startButton;
    private Button stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton=findViewById(R.id.startButton_id);
        stopButton=findViewById(R.id.stopButton_id);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"startButton cliccato");
                startService(new Intent(getBaseContext(),MyService.class));
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"stopButton cliccato");
                stopService(new Intent(getBaseContext(),MyService.class));
            }
        });
    }
}
