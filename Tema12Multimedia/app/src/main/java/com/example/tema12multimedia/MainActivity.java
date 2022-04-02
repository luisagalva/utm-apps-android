package com.example.tema12multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaController mediaController = new MediaController(this);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("https://luisaplex2.blob.core.windows.net/myblobs/2022-03-03%2013-06-52.mkv");

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Log.i("Video_view_tag", "el video esta listo para reproducirse");
                mediaPlayer.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.i("Video_view_tag", "video completo");
            }
        });
    }
}