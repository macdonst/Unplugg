package com.simonmacdonald.unplugg;

import org.apache.cordova.DroidGap;

import android.os.Bundle;

public class UnpluggActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // super.setIntegerProperty("splashscreen", R.drawable.splash);
        this.setStringProperty("errorUrl", "file:///android_asset/www/error.html");
        super.loadUrl("file:///android_asset/www/index.html");
    }
}