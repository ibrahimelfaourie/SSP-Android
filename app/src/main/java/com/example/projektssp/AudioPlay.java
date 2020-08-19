package com.example.projektssp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

// Nusret
// https://stackoverflow.com/questions/16690057/how-can-i-stop-media-player-in-another-activity
// Method to start playing any sound in any other class and method
public class AudioPlay {

    public static MediaPlayer backgroundMusic;
    public static boolean isplayingAudio = false;

    public static void playAudio(Context c, int id){
        backgroundMusic = MediaPlayer.create(c,id);

        if(!backgroundMusic.isPlaying())
        {
            isplayingAudio = true;
            backgroundMusic.setVolume(0.05f, 0.05f);
            backgroundMusic.setLooping(true);
            backgroundMusic.start();
        }
    }

    // A method to stop all sound that is being activated by this class
    public static void stopAudio(){
        isplayingAudio = false;
        backgroundMusic.stop();
    }
}
