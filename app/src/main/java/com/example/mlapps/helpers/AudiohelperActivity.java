package com.example.mlapps.helpers;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mlapps.R;

public class  AudiohelperActivity extends AppCompatActivity {

    protected TextView outputTextview;
    protected TextView specsTextview;
    protected Button startRecordingButton;
    protected Button stopRecordingButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiohelper);

        outputTextview = findViewById(R.id.audio_output_textView);
        specsTextview = findViewById(R.id.audio_specs_textView);
        startRecordingButton = findViewById(R.id.audio_btn_start_recording);
        stopRecordingButton = findViewById(R.id.audio_btn_stop_recording);

        stopRecordingButton.setEnabled(false);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){

            //we dont want to ask user every time to give permission so once user gave permission
            // //we dont execute this code
            if(checkSelfPermission(Manifest.permission.RECORD_AUDIO)
                     != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
            }
        }
    }
    public void startRecording(View view){
        startRecordingButton.setEnabled(false);
        stopRecordingButton.setEnabled(true);
    }
    public void stopRecording(View view){
        startRecordingButton.setEnabled(true);
        stopRecordingButton.setEnabled(false);
    }
}