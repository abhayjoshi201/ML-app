package com.example.mlapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mlapps.helpers.FlowerIdentificationActivity;
import com.example.mlapps.helpers.ImageHelperActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onGotoImageAcivity(View view){
        //start image activity
        Intent intent = new Intent(this, ImageClassificationActivity.class);
        startActivity(intent);
    }
    public void onGotoFlowerIdentification(View view){
        //start image activity
        Intent intent = new Intent(this, FlowerIdentificationActivity.class);
        startActivity(intent);
    }
}