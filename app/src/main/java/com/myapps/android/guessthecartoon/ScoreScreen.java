package com.myapps.android.guessthecartoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
        displayScore(Game.score);
    }

    public void playGame(View view)
    {
        Intent k = new Intent("com.myapps.android.guessthecartoon.Game");
        startActivity(k);
    }

    public void displayMainMenu(View view)
    {
        Intent k = new Intent(ScoreScreen.this,MainScreen.class);
        startActivity(k);
    }

    private void displayScore(int number)
    {
        TextView score = (TextView) findViewById(R.id.score_text_view);
        score.setText("Score: "+number);
    }

}
