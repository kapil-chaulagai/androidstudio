package com.isteer.iframe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String [] names = {"Marvel", "Chris Evans", "Robert Downey", "Ryan", "Stan Lee", "The Rock"};
    TextView text;
    ImageView pic;
    int currentImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.status);
    }
    public void prev(View v){
        String idX = "pic" + currentImage;
        int x = this.getResources().getIdentifier(idX,"id", getPackageName());
        pic = findViewById(x);
        pic.setAlpha(0f);

        currentImage = (6 + currentImage - 1) % 6;
        String idY = "pic" + currentImage;
        int y = this.getResources().getIdentifier(idY,"id", getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);

        text.setText(names[currentImage]);
    }
    public void next(View v){
        String idX = "pic"+currentImage;
        int x = this.getResources().getIdentifier(idX,"id", getPackageName());
        pic = findViewById(x);
        pic.setAlpha(0f);

        currentImage = (currentImage +1 ) % 6;
        String idY = "pic" + currentImage;
        int y = this.getResources().getIdentifier(idY,"id", getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);

        text.setText(names[currentImage]);
    }
}