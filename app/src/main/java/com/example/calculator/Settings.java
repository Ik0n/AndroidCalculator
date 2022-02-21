package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    RadioGroup themes;

    RadioButton darkTheme;
    RadioButton lightTheme;

    Button launch;

    String theme = "light_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Calculator_Light);
        setContentView(R.layout.activity_settings);

        themes = findViewById(R.id.themes);

        darkTheme = findViewById(R.id.dark_theme);
        darkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.Theme_Calculator_Dark);
                theme = "dark_theme";
            }
        });
        lightTheme = findViewById(R.id.light_theme);
        lightTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.Theme_Calculator_Light);
                theme = "light_theme";
            }
        });



        launch = findViewById(R.id.launch_button);

        launch.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent runCalculator = new Intent(Settings.this, MainActivity.class);
        runCalculator.putExtra("Theme", theme);
        recreate();
        startActivity(runCalculator);
    }
}