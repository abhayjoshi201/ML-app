package com.example.mlapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mlapps.audio.AudioClassificationActivity;
import com.example.mlapps.helpers.AudiohelperActivity;
import com.example.mlapps.image.FaceDetectionActivity;
import com.example.mlapps.image.FlowerIdentificationActivity;
import com.example.mlapps.image.ImageClassificationActivity;
import com.example.mlapps.image.ObjectDetectionActivity;
import com.google.mlkit.vision.objects.ObjectDetection;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onGotoImageActivity(View view){
        //start image activity
        Intent intent = new Intent(this, ImageClassificationActivity.class);
        startActivity(intent);
    }
    public void onGotoFlowerIdentification(View view){
        //start image activity
        Intent intent = new Intent(this, FlowerIdentificationActivity.class);
        startActivity(intent);
    }
    public void onGotoFaceDetection(View view){
        //start image activity
        Intent intent = new Intent(this, FaceDetectionActivity.class);
        startActivity(intent);
    }

      public void onGotoObjectDetection(View view){
        //start image activity
        Intent intent = new Intent(this, ObjectDetectionActivity.class);
        startActivity(intent);
    }
}