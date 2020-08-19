package com.example.projektssp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Nusret
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call the playAudio method from AudioPlay Class with the getAplicationContext and the audio file id
        // within the parameters
        AudioPlay.playAudio(getApplicationContext(), R.raw.backgroundmusic);

        Button start = (Button)findViewById(R.id.startbutton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, GameMode.class));
            }
        });

    }

}
