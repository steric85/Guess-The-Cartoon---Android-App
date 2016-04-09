package com.myapps.android.guessthecartoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        Intent i  = getIntent();
        score  = i.getIntExtra("SCORE",0);
        displayScore(score);
    }

    public void playGame(View view)
    {
        Intent k = new Intent(ScoreScreen.this,Game.class);
        startActivity(k);
        finish();
    }

    public void displayMainMenu(View view)
    {
        Intent k = new Intent(ScoreScreen.this,MainScreen.class);
        startActivity(k);
        finish();
    }

    private void displayScore(int temp_score)
    {
        TextView score = (TextView) findViewById(R.id.score_text_view);
        score.setText("Score: "+temp_score);
    }

}
