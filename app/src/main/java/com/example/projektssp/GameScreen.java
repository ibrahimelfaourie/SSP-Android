package com.example.projektssp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {

    String playerChoice;
    String cpuChoice;

    TextView roundsNo, playerScore, cpuScore;
    Button rockButton, scissorButton, paperButton, resultButton;
    ImageView rockPlayer, scissorPlayer, paperPlayer, rockCPU, scissorCPU, paperCPU;

    // Nusret
    // The game
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);

        engienSSP();

        resultButton = findViewById(R.id.resultButton);
        resultButton.setEnabled(false);
        resultButton.setVisibility(View.GONE);


        // result screen button
       /* resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeResultScreen();
            }
        });*/
}

    // Ibrahim
// CPU randomly picks a hand
    public void handCPU () {
        Random hand = new Random();
        int cpuHand = hand.nextInt(3);

        switch (cpuHand) {
            case 0:
                rockCPU.setVisibility(View.VISIBLE);
                scissorCPU.setVisibility(View.GONE);
                paperCPU.setVisibility(View.GONE);
                cpuChoice = "Rock";
                break;

            case 1:
                rockCPU.setVisibility(View.GONE);
                scissorCPU.setVisibility(View.VISIBLE);
                paperCPU.setVisibility(View.GONE);
                cpuChoice = "Scissors";
                break;

            case 2:
                rockCPU.setVisibility(View.GONE);
                scissorCPU.setVisibility(View.GONE);
                paperCPU.setVisibility(View.VISIBLE);
                cpuChoice = "Paper";
                break;
        }
    }

    // Nusret
    public void engienSSP() {
        rockButton = findViewById(R.id.rockButton);
        scissorButton = findViewById(R.id.scissorButton);
        paperButton = findViewById(R.id.paperButton);

        // Player Images
        rockPlayer = findViewById(R.id.rockPlayer);
        scissorPlayer = findViewById(R.id.scissorPlayer);
        paperPlayer = findViewById(R.id.paperPlayer);

        rockPlayer.setVisibility(View.GONE);
        scissorPlayer.setVisibility(View.GONE);
        paperPlayer.setVisibility(View.GONE);

        // CPU images
        rockCPU = findViewById(R.id.rockCPU);
        scissorCPU = findViewById(R.id.scissorCPU);
        paperCPU = findViewById(R.id.paperCPU);

        rockCPU.setVisibility(View.GONE);
        scissorCPU.setVisibility(View.GONE);
        paperCPU.setVisibility(View.GONE);

        // Everything that happens when pressing down on the Rock button
            rockButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rockPlayer.setVisibility(View.VISIBLE);
                    scissorPlayer.setVisibility(View.GONE);
                    paperPlayer.setVisibility(View.GONE);
                    playerChoice = "Rock";
                    handCPU();
                    System.out.println("Player: " + playerChoice + " CPU: " + cpuChoice);
                    playerRock();
                    System.out.println("Player score: " + GameDataHolder.getPlayer() + " CPU score: " + GameDataHolder.getCpu());
                    gameStateCheck();
                    delayButtons();
                }
            });

        // Everything that happens when pressing down on the Scissors button
            scissorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rockPlayer.setVisibility(View.GONE);
                    scissorPlayer.setVisibility(View.VISIBLE);
                    paperPlayer.setVisibility(View.GONE);
                    playerChoice = "Scissors";
                    handCPU();
                    System.out.println("Player: " + playerChoice + " CPU: " + cpuChoice);
                    playerScissors();
                    System.out.println("Player score: " + GameDataHolder.getPlayer() + " CPU score: " + GameDataHolder.getCpu());
                    gameStateCheck();
                    delayButtons();
                }
            });

        // Everything that happens when pressing down on the Paper button
            paperButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rockPlayer.setVisibility(View.GONE);
                    scissorPlayer.setVisibility(View.GONE);
                    paperPlayer.setVisibility(View.VISIBLE);
                    playerChoice = "Paper";
                    handCPU();
                    System.out.println("Player: " + playerChoice + " CPU: " + cpuChoice);
                    playerPaper();
                    System.out.println("Player score: " + GameDataHolder.getPlayer() + " CPU score: " + GameDataHolder.getCpu());
                    gameStateCheck();
                    delayButtons();
                }
            });

    }

    // Nusret
    // Game logic when player picks rock
    public void playerRock() {
        roundsNo = findViewById(R.id.roundsNo);
        playerScore = findViewById(R.id.playerScore);
        cpuScore = findViewById(R.id.cpuScore);

        if ((playerChoice =="Rock") && (cpuChoice == "Rock")) {
            rockxrockSound();

            Toast.makeText(this,   "Drawn", Toast.LENGTH_SHORT).show();
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
        }

        if ((playerChoice =="Rock") && (cpuChoice == "Paper")) {
            rockxpaperSound();

            Toast.makeText(this,   "You got eaten by paper", Toast.LENGTH_SHORT).show();
            GameDataHolder.cpu++;
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
            cpuScore.setText(GameDataHolder.getCpu() + "");
        }

        if ((playerChoice =="Rock") && (cpuChoice == "Scissors")) {
            scissorsxrockSound();

            Toast.makeText(this,   "You crushed some scissors", Toast.LENGTH_SHORT).show();
            GameDataHolder.player++;
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
            playerScore.setText(GameDataHolder.getPlayer() + "");
        }
    }

    // Nusret
// game logic when player picks scissors
    public  void playerScissors() {
        roundsNo = findViewById(R.id.roundsNo);
        playerScore = findViewById(R.id.playerScore);
        cpuScore = findViewById(R.id.cpuScore);

        if ((playerChoice =="Scissors") && (cpuChoice == "Rock")) {
            scissorsxrockSound();

            Toast.makeText(this,   "You lost to Rock", Toast.LENGTH_SHORT).show();
            GameDataHolder.cpu++;
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
            cpuScore.setText(GameDataHolder.getCpu() + "");
        }

        if ((playerChoice =="Scissors") && (cpuChoice == "Paper")) {
            paperxscissorsSound();

            Toast.makeText(this,   "You cut the paper", Toast.LENGTH_SHORT).show();
            GameDataHolder.player++;
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
            playerScore.setText(GameDataHolder.getPlayer() + "");
        }

        if ((playerChoice =="Scissors") && (cpuChoice == "Scissors")) {
            scissorsxscissorsSound();

            Toast.makeText(this,   "Drawn", Toast.LENGTH_SHORT).show();
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
        }
    }

    // Nusret
// game logic when player picks paper
    public void playerPaper() {
        roundsNo = findViewById(R.id.roundsNo);
        playerScore = findViewById(R.id.playerScore);
        cpuScore = findViewById(R.id.cpuScore);

        if ((playerChoice =="Paper") && (cpuChoice == "Rock")) {
            rockxpaperSound();

            Toast.makeText(this,   "You enveloped paper", Toast.LENGTH_SHORT).show();
            GameDataHolder.player++;
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
            playerScore.setText(GameDataHolder.getPlayer() + "");
        }

        if ((playerChoice =="Paper") && (cpuChoice == "Scissors")) {
            paperxscissorsSound();

            Toast.makeText(this,   "You got cut by scissors", Toast.LENGTH_SHORT).show();
            GameDataHolder.cpu++;
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
            cpuScore.setText(GameDataHolder.getCpu() + "");
        }

        if ((playerChoice =="Paper") && (cpuChoice == "Paper")) {
            paperxpaperSound();

            Toast.makeText(this,   "Drawn", Toast.LENGTH_SHORT).show();
            GameDataHolder.rounds++;
            roundsNo.setText("Round " + GameDataHolder.getRounds());
        }
    }

    // Nusret
    // Determines who is the winner
    public void gameStateCheck() {
        roundsNo = findViewById(R.id.roundsNo);
        playerScore = findViewById(R.id.playerScore);
        cpuScore = findViewById(R.id.cpuScore);
        resultButton = findViewById(R.id.resultButton);

            int maxWins = GameMode.DataHolder.getBestOf();
            int maxRounds = GameMode.DataHolder.getRoundsOf();

        if (GameDataHolder.player == maxWins || GameDataHolder.cpu == maxWins || GameDataHolder.rounds == maxRounds) {
            startResult();

            /* If I want to use result button instead of instant transition to result screen
            rockPlayer.setVisibility(View.GONE);
            scissorPlayer.setVisibility(View.GONE);
            paperPlayer.setVisibility(View.GONE);

            rockCPU.setVisibility(View.GONE);
            scissorCPU.setVisibility(View.GONE);
            paperCPU.setVisibility(View.GONE);

            rockButton.setEnabled(false);
            scissorButton.setEnabled(false);
            paperButton.setEnabled(false);

            resultButton.setEnabled(true);
            resultButton.setVisibility(View.VISIBLE); */
        }
    }

    // Nusret
    // Go to result screen with a button
    /*
    public void changeResultScreen(){

            resultButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(GameScreen.this, ResultScreen.class));
                }
            });
    }*/

    // Nusret
    // https://stackoverflow.com/questions/15874117/how-to-set-delay-in-android
    // Delaying the unlock of buttons and hides the player and cpu's hands
    public  void delayButtons () {
        final Handler handler = new Handler();

        rockButton.setEnabled(false);
        scissorButton.setEnabled(false);
        paperButton.setEnabled(false);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rockPlayer.setVisibility(View.GONE);
                scissorPlayer.setVisibility(View.GONE);
                paperPlayer.setVisibility(View.GONE);

                rockCPU.setVisibility(View.GONE);
                scissorCPU.setVisibility(View.GONE);
                paperCPU.setVisibility(View.GONE);

                rockButton.setEnabled(true);
                scissorButton.setEnabled(true);
                paperButton.setEnabled(true);
            }
        }, 2000);
    }

    // Nusret
    // From the school presentation, plays a sound effect
    public void rockxrockSound () {
        MediaPlayer rxr = MediaPlayer.create(
                getApplicationContext(),
                R.raw.rockxrock);
        rxr.start();
    }

    public void rockxpaperSound () {
        MediaPlayer rxp = MediaPlayer.create(
                getApplicationContext(),
                R.raw.rockxpaper);
        rxp.start();
    }

    public void scissorsxscissorsSound () {
        MediaPlayer sxs = MediaPlayer.create(
                getApplicationContext(),
                R.raw.scissorsxscissors);
        sxs.start();
    }

    public void scissorsxrockSound () {
        MediaPlayer sxr = MediaPlayer.create(
                getApplicationContext(),
                R.raw.scissorsxrock);
        sxr.start();
    }

    public void paperxpaperSound () {
        MediaPlayer pxp = MediaPlayer.create(
                getApplicationContext(),
                R.raw.paperxpaper);
        pxp.start();
    }

    public void paperxscissorsSound () {
        MediaPlayer pxs = MediaPlayer.create(
                getApplicationContext(),
                R.raw.paperxscissors);
        pxs.start();
    }

    // Nusret
    // 2 seconds after calling this method it goes to the result screen
    public void startResult() {
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AudioPlay.stopAudio();
                startActivity(new Intent(GameScreen.this, ResultScreen.class));
            }
        }, 2000);

    }

    // Nusret
    // DataHolder for all the important information that needs to be transferred to other screens
    public static class GameDataHolder {
        private static int player;
        private static int cpu;
        private static int rounds;

        public static int getPlayer() {return player;}
        public static void setPlayer(int player) {GameDataHolder.player = player;}

        public static int getCpu() {return cpu;}
        public static void setCpu(int cpu) {GameDataHolder.cpu = cpu;}

        public static int getRounds() {return rounds;}
        public static void setRounds(int rounds) {GameDataHolder.rounds = rounds;}
    }
}
