package com.isteer.multiscreenrestro;

import static com.isteer.multiscreenrestro.MainActivity.RSP;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    EditText response;
    TextView textView;
    Button button_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MSG);
//        Set text inside textview to message for order fragment
        textView = findViewById(R.id.intentView);
        textView.setText(message);
    }

//    @Override
//    protected void onPause() {
//        textView.setText("");
//        response.setText("");
//        super.onPause();
//    }

    public void responseOnOrder(View view) {
        //       Set this for response fragment
        Intent intent1 = new Intent(this, MainActivity.class);
        response = findViewById(R.id.response);
        button_response = findViewById(R.id.button_response);

        button_response.setOnClickListener(view1 -> {
            String responseMessage = response.getText().toString();
            boolean check = validateInfo(responseMessage);
            if (check) {
                Toast.makeText(getApplicationContext(), "Order Received.", Toast.LENGTH_SHORT).show();
                String received = "Your Order for " + responseMessage + " will be ready within 10 minutes🍽.";
                intent1.putExtra(RSP, received);
                startActivity(intent1);
            } else {
                Toast.makeText(getApplicationContext(), "Item not found.!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validateInfo(String responseMessage) {
        if (responseMessage.length() == 0) {
            response.requestFocus();
            response.setError("Field cannot be empty.!!");
            return false;
        } else {
            return true;
        }
    }
}