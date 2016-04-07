package com.myapps.android.guessthecartoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    static public int score = 0;
    int levelNo=1;
    String[] cartoonNames={"MickeyMouse","Dexter","PinkPanther","FredFlinstone","KimPossible" };

    public void increLevel(View view) {
        levelNo++;
        if(levelNo>5)
        {
            Intent i = new Intent("com.myapps.android.guessthecartoon.ScoreScreen");
            startActivity(i);
        }
        else
            displayLevel(levelNo);
    }

    public void decreLevel(View view)
    {
        levelNo--;
        if(levelNo<1)
        {
            Intent i = new Intent("com.myapps.android.guessthecartoon.MainScreen");
            startActivity(i);
        }
        else
            displayLevel(levelNo);
    }

    private void displayLevel(int number)
    {
        TextView levelTextView = (TextView) findViewById(R.id.level_number);
        levelTextView.setText("Level "+number);
    }
}
