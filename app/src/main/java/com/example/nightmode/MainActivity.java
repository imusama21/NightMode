package com.example.nightmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch switchNightMode;
    private int currentMode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchNightMode = findViewById(R.id.switchNightMode);
        currentMode = AppCompatDelegate.getDefaultNightMode();

        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            switchNightMode.setChecked(true);
        } else {
            switchNightMode.setChecked(false);
        }

        switchNightMode.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            restartCurrentActivity();
        });

    }

    private void restartCurrentActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}