package com.example.mlapps.image;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.mlapps.helpers.ImageHelperActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.label.ImageLabel;
import com.google.mlkit.vision.label.ImageLabeler;
import com.google.mlkit.vision.label.ImageLabeling;
import com.google.mlkit.vision.label.custom.CustomImageLabelerOptions;

public class FlowerIdentificationActivity extends ImageHelperActivity {

    private ImageLabeler imageLabeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocalModel localModel = new LocalModel.Builder().setAssetFilePath("model_flowers.tflite").build();
        CustomImageLabelerOptions options = new CustomImageLabelerOptions.Builder(localModel)
                .setConfidenceThreshold(0.7f)
                .setMaxResultCount(5).build();

        imageLabeler = ImageLabeling.getClient(options);
    }
    protected void runClassification(Bitmap bitmap) {
        InputImage inputImage = InputImage.fromBitmap(bitmap, 0);
        imageLabeler.process(inputImage).addOnSuccessListener(imageLabels -> {
            StringBuilder sb = new StringBuilder();
            for (ImageLabel label : imageLabels) {
                sb.append(label.getText()).append(": ").append(label.getConfidence()).append("\n");
            }
            if (imageLabels.isEmpty()) {
                getOutputTextView().setText("Could not detect");
            } else {
                getOutputTextView().setText(sb.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });
    }
}