package com.example.projektssp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GameMode extends AppCompatActivity {


    Button gameModeStart;
    RadioGroup roundsNo;
    RadioButton radioButton;

    // Nusret
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeActionContentDescription("Hej");

        gameModeStart = findViewById(R.id.gameModeStart);
        roundsNo = findViewById(R.id.roundsNo);

        gameModeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameMode.this, GameScreen.class));
            }
        });
    }

    // Nusret
    /* Android back button on the bottom
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    } */

    // Nusret
    // Android back button arrow at the top left
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }

    // Nusret
    // YouTube and https://stackoverflow.com/questions/39715867/android-how-to-enable-a-button-if-a-radio-button-is-checked
    // Radiogroup and the buttons, and what happens when selecting them
    public void radioButtonCheck (View v) {
        int radioId = roundsNo.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this,  radioButton.getText() + " rounds",Toast.LENGTH_LONG).show();

        gameModeStart.setEnabled(true);

        switch(radioId)
        {
            case R.id.r3:
                DataHolder.setBestOf(2);
                DataHolder.setRoundsOf(3);
                System.out.println("BestOf : " + DataHolder.getBestOf() + "\n" + "Rounds: " + DataHolder.getRoundsOf());
                GameScreen.GameDataHolder.setRounds(0);
                GameScreen.GameDataHolder.setPlayer(0);
                GameScreen.GameDataHolder.setCpu(0);
                break;

            case R.id.r5:
                DataHolder.setBestOf(3);
                DataHolder.setRoundsOf(5);
                System.out.println("BestOf : " + DataHolder.getBestOf() + "\n" + "Rounds: " + DataHolder.getRoundsOf());
                GameScreen.GameDataHolder.setRounds(0);
                GameScreen.GameDataHolder.setPlayer(0);
                GameScreen.GameDataHolder.setCpu(0);
                break;

            case R.id.r7:
                DataHolder.setBestOf(4);
                DataHolder.setRoundsOf(7);
                System.out.println("BestOf : " + DataHolder.getBestOf() + "\n" + "Rounds: " + DataHolder.getRoundsOf());
                GameScreen.GameDataHolder.setRounds(0);
                GameScreen.GameDataHolder.setPlayer(0);
                GameScreen.GameDataHolder.setCpu(0);
                break;

            case R.id.r9:
                DataHolder.setBestOf(5);
                DataHolder.setRoundsOf(9);
                System.out.println("BestOf : " + DataHolder.getBestOf() + "\n" + "Rounds: " + DataHolder.getRoundsOf());
                GameScreen.GameDataHolder.setRounds(0);
                GameScreen.GameDataHolder.setPlayer(0);
                GameScreen.GameDataHolder.setCpu(0);
                break;

            case R.id.r11:
                DataHolder.setBestOf(6);
                DataHolder.setRoundsOf(11);
                System.out.println("BestOf : " + DataHolder.getBestOf() + "\n" + "Rounds: " + DataHolder.getRoundsOf());
                GameScreen.GameDataHolder.setRounds(0);
                GameScreen.GameDataHolder.setPlayer(0);
                GameScreen.GameDataHolder.setCpu(0);
                break;

            case R.id.r13:
                DataHolder.setBestOf(7);
                DataHolder.setRoundsOf(13);
                System.out.println("BestOf : " + DataHolder.getBestOf() + "\n" + "Rounds: " + DataHolder.getRoundsOf());
                GameScreen.GameDataHolder.setRounds(0);
                GameScreen.GameDataHolder.setPlayer(0);
                GameScreen.GameDataHolder.setCpu(0);
                break;
        }

    }

    // Nusret
    // https://stackoverflow.com/questions/4878159/whats-the-best-way-to-share-data-between-activities
    // DataHolder to save data and use in another activity
    public static class DataHolder {
        private static int bestOf;
        private static int roundsOf;

        public static int getBestOf() {return bestOf;}
        public static void setBestOf(int bestOf) {DataHolder.bestOf = bestOf;}

        public static int getRoundsOf() {return roundsOf;}
        public static void setRoundsOf(int roundsOf) {DataHolder.roundsOf = roundsOf;}
    }
}
