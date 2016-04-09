package com.myapps.android.guessthecartoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Process;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void playGame(View view)
    {
        Intent k = new Intent(MainScreen.this,Game.class);
        startActivity(k);
    }

    public void terminateApp(View view)
    {
        finishAffinity();
    }
}
