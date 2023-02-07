package com.isteer.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.isteer.tictactoe.ui.main.MainFragment;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
//    Player Representations
//    0 - X
//    1 - O
    int activePlayer = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
//    State meanings
//    0 - X
//    1 - O
//    2 - Null
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @SuppressLint("SetTextI18n")
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x_key);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn : Tap to Play");
            } else {
                img.setImageResource(R.drawable.o_key);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn : Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
//        Check if any player wins
        for(int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]]
                    && gameState[winPosition[0]] != 2) {
//          Somebody has won-- who?
                String winStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winStr = "X has won the game🎉.";
                } else {
                    winStr = "O has won the game🎉.";
                }
//            Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winStr);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn : Tap to Play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}

//    //        draw game
//    int count =0;
//                for(int i=0;i<gameState.length;i++){
//        if(gameState[i]==2){
//        count++;
//        }
//        }
//        if(count>0){
//        gameActive=false;
//        TextView status = findViewById(R.id.status);
//        status.setText("Game Draw!!");
//        }