package com.example.projektssp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    TextView roundStats, playerStats, cpuStats, winnerStats;
    Button homeButton;

    // Ibrahim
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultscreen);

        MediaPlayer sparkle = MediaPlayer.create(
                getApplicationContext(),
                R.raw.sparkleresults);
        sparkle.setVolume(0.5f, 0.5f);
        sparkle.start();


        roundStats = findViewById(R.id.roundStats);
        playerStats = findViewById(R.id.playerStats);
        cpuStats = findViewById(R.id.cpuStats);

        homeButton = findViewById(R.id.homeButton);
        //homeButton.setBackgroundColor(Color.RED);

        roundStats.setText("Rounds: " + GameScreen.GameDataHolder.getRounds());
        playerStats.setText("Player: " + GameScreen.GameDataHolder.getPlayer());
        cpuStats.setText("CPU: " + GameScreen.GameDataHolder.getCpu());

        winnerText();

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultScreen.this, MainActivity.class));
            }
        });
    }

    // Ibrahim
        public void winnerText () {
        winnerStats = findViewById(R.id.winnerStats);

        if (GameScreen.GameDataHolder.getCpu() > GameScreen.GameDataHolder.getPlayer()) {
            winnerStats.setText("CPU is the winner! " + "\n" + "Too bad player and better luck next time!");
        }

        if (GameScreen.GameDataHolder.getCpu() < GameScreen.GameDataHolder.getPlayer()) {
            winnerStats.setText("Player is the winner! " + "\n" + "Too bad CPU and better luck next time!");
        }

        if (GameScreen.GameDataHolder.getCpu() == GameScreen.GameDataHolder.getPlayer()) {
            winnerStats.setText("There are no winner because it's a drawn! " + "\n" + "Better luck next time!");
        }
    }
}
