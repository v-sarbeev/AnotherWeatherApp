package ru.pixnstix.anotherweatherapp.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.pixnstix.anotherweatherapp.R;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);
    }
}
