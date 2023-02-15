package com.isteer.listviewproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.listView);
        ArrayList<String> items = new ArrayList<>();
        items.add("Book");
        items.add("Pen");
        items.add("Cauli Flower");
        items.add("Paneer");
        items.add("Rajma");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = "Item "+(i+1)+ " is "+ ((TextView) view).getText().toString()+" .";
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}