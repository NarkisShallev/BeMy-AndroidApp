package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beMyClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, beMyChoose.class);
        startActivity(intent);
    }
    public void beForClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, ---------.class);
        startActivity(intent);
    }
}
