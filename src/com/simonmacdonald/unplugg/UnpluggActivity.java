package com.simonmacdonald.unplugg;

import com.phonegap.DroidGap;

import android.os.Bundle;

public class UnpluggActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.init();
        // super.setIntegerProperty("splashscreen", R.drawable.splash);
        //this.appView.getSettings().setPluginsEnabled(true);
        this.setStringProperty("errorUrl", "file:///android_asset/www/error.html");
        //this.appView.getSettings().setUseWideViewPort(true);
        //this.appView.getSettings().setLoadWithOverviewMode(true);
        //this.appView.setInitialScale(0); 
        super.loadUrl("file:///android_asset/www/index.html");
    }
}