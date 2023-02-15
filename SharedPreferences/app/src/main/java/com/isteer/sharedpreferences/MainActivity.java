package com.isteer.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();

                SharedPreferences shared = getSharedPreferences("first",MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();

                editor.putString("Message",msg);
                editor.apply();
                textView.setText(msg);
            }
        });
//        get the value of shared preferences back
        SharedPreferences getShared = getSharedPreferences("first",MODE_PRIVATE);
        String value = getShared.getString("Message","Save a note first..!!");
        textView.setText(value);
    }
}