package com.isteer.dbrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.isteer.dbrecyclerview.adapter.RecyclerViewAdapter;
import com.isteer.dbrecyclerview.data.MyDbHandler;
import com.isteer.dbrecyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(MainActivity.this);

//        Creating to add into the db
        Contact cont = new Contact();
        cont.setName("Mr. Vaishakh");
        cont.setPhoneNumber("759843755");

//        Add to the table in db
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);
        db.addContact(cont);

        Log.d("MrKap", "All data are inserted..!!");

//      Display in list view
        contactArrayList = new ArrayList<>();

//        Get all contacts
        List<Contact> contacts = db.getAllContacts();
        for(Contact contact : contacts){
//            Log.d("MrKap", "Id: "+contact.getId()+ " \n"+
//                    "Name: "+contact.getName()+ " \n"+
//                    "Phone Number: "+contact.getPhoneNumber());
            contactArrayList.add(contact);
        }
//        Use your recycler view adapter
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}