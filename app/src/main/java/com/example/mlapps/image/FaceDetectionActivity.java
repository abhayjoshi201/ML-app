package com.example.mlapps.image;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.renderscript.ScriptGroup;

import androidx.annotation.NonNull;

import com.example.mlapps.helpers.BoxWithLabel;
import com.example.mlapps.helpers.ImageHelperActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

import java.util.ArrayList;
import java.util.List;

public class FaceDetectionActivity extends ImageHelperActivity {

    private FaceDetector faceDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FaceDetectorOptions highAccuracyOpts = new FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                .enableTracking()
                .build();

        faceDetector = FaceDetection.getClient(highAccuracyOpts);
    }

    @Override
    protected void runClassification(Bitmap bitmap) {

        InputImage inputImage = InputImage.fromBitmap(outputBitmap,0);
        Bitmap outputBitmap = bitmap.copy(Bitmap.Config.ARGB_8888,true);

        faceDetector.process(inputImage)
                .addOnSuccessListener(new OnSuccessListener<List<Face>>() {
                    @Override
                    public void onSuccess(List<Face> faces) {
                        if (faces.isEmpty()) {
                            getOutputTextView().setText("No faces Detected");
                        } else {
                            List<BoxWithLabel> boxes = new ArrayList<>();
                            for (Face face : faces){
                                BoxWithLabel boxWithLabel = new BoxWithLabel(
                                        face.getBoundingBox(),
                                        face.getTrackingId()+""
                                );
                                boxes.add(boxWithLabel);
                            }
                            drawDetectionResult(boxes,bitmap);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
