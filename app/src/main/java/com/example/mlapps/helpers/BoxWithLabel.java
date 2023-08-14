package com.example.mlapps.helpers;

import android.graphics.Rect;

public class BoxWithLabel {
    public Rect rect;
    public String label;

    public BoxWithLabel(Rect rect, String label) {
        this.rect = rect;
        this.label = label;
    }
}
