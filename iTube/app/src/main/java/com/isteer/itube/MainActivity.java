package com.isteer.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Set Video on Video View
        VideoView stream = findViewById(R.id.stream);
        stream.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.sample);
        MediaController controller = new MediaController(this);
        stream.setMediaController(controller);
        controller.setAnchorView(stream);
        stream.start();
    }
}