package com.example.whatdoyouwannawatch;

import android.graphics.Bitmap;

import org.json.JSONException;

import java.io.IOException;

public interface ApiCallback {
    //In this callback interface, the onCallback function will
    //be called back and loaded with a parameter that I can set
    void onCallback(Bitmap result) throws JSONException, IOException;
}