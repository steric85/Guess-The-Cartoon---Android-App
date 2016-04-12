package com.myapps.android.guessthecartoon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    int score;
    public static final int DEFAULT=Integer.MIN_VALUE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        Intent i  = getIntent();
        score  = i.getIntExtra("SCORE",0);
        displayScore(score);
        determineHighScore(score);
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
        score.setText(score.getText().toString()+temp_score);
    }

    private void displayHighScore(int temp_high_score)
    {
        TextView highscore = (TextView) findViewById(R.id.highscore_text_view);
        highscore.setText(highscore.getText().toString()+temp_high_score);
    }

    private void determineHighScore(int temp_score)
    {
        SharedPreferences sharedPreferences =getPreferences(Context.MODE_PRIVATE);
        int highscore = sharedPreferences.getInt("highestScore",DEFAULT);
        if(highscore<temp_score) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highestScore", temp_score);
            editor.commit();
            highscore=temp_score;
        }
        displayHighScore(highscore);
    }

}
