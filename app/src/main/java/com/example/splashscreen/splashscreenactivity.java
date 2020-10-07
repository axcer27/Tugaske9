package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

public class splashscreenactivity extends AppCompatActivity {

    public static final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogin()) {
                    Intent intent = new Intent(splashscreenactivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(splashscreenactivity.this, loginactivity.class);
                    startActivity(intent);
                }
                finish();

            }
        }, 3000);
    }
    boolean isLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}