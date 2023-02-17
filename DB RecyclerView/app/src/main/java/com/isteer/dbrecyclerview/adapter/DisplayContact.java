package com.isteer.dbrecyclerview.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.isteer.dbrecyclerview.R;

public class DisplayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Rname");
        String phone = intent.getStringExtra("Rphone");

        TextView nameText = findViewById(R.id.displayName);
        nameText.setText(name);

        TextView phoneText = findViewById(R.id.displayPhone);
        phoneText.setText(phone);
    }
}