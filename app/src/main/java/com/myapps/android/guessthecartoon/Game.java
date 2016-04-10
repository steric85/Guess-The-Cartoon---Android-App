package com.myapps.android.guessthecartoon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.CharSequence;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

public class Game extends AppCompatActivity {

    int score = 0;
    int levelNo=1;
    String temp = "Wrong Answer!";
    String[] cartoonNames={"MickeyMouse","Dexter","PinkPanther","FredFlinstone","KimPossible" };
    int cartoonImages[]={R.drawable.mickey,R.drawable.dexter,R.drawable.pink_panther,R.drawable.fred_flintstone,R.drawable.kim_possible};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    private void increLevel() {

        levelNo++;
        if(levelNo>5)
        {
            Intent i = new Intent(Game.this,ScoreScreen.class);
            i.putExtra("SCORE",score);
            startActivity(i);
            finish();
        }
        else
        {
            changeLevel(levelNo);
            changeCartoon();
        }
    }

    public void decreLevel(View view)
    {
        levelNo--;
        if(levelNo<1)
        {
            Intent i = new Intent(Game.this,MainScreen.class);
            startActivity(i);
            finish();
        }
        else
        {
            changeLevel(levelNo);
            changeCartoon();
        }
    }

    public void checkAnswer(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.input);

        if(nameEditText.getText().toString().replace(" ","").equalsIgnoreCase(cartoonNames[levelNo-1]))
        {
            updateScore();
            increLevel();
            if(levelNo<=5)
                nameEditText.setText("");
        }
        else
        {
            if(!nameEditText.getText().toString().isEmpty())
            {
                Toast.makeText(this,""+temp,Toast.LENGTH_SHORT).show();
                nameEditText.setText("");
            }
            else
            {
                increLevel();
            }
        }
    }

    private void changeLevel(int number)
    {
        TextView levelTextView = (TextView) findViewById(R.id.level_number);
        levelTextView.setText("Level "+number);
    }

    private void changeCartoon()
    {
        ImageView cartoonTextView =(ImageView) findViewById(R.id.cartoon);
        cartoonTextView.setImageResource(cartoonImages[levelNo-1]);
    }

    private void updateScore()
    {
        TextView scoreTextView =(TextView) findViewById(R.id.score);
        score +=250;
        scoreTextView.setText(String.valueOf(score));
    }

}
