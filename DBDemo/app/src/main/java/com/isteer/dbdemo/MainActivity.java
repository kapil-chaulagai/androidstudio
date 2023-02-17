package com.isteer.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.isteer.dbdemo.data.MyDbHandler;
import com.isteer.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

//        Creating to add into the db
        Contact cont = new Contact();
        cont.setName("Mr. Vaishakh");
        cont.setPhoneNumber("759843755");

        Contact cont1 = new Contact();
        cont.setName("Mr. Deepak");
        cont.setPhoneNumber("8732879722");

        Contact cont2 = new Contact();
        cont.setName("Mr. Raja");
        cont.setPhoneNumber("7328972308");

        Contact cont3 = new Contact();
        cont.setName("Mr. Rani");
        cont.setPhoneNumber("732898798");

//        Add to the table in db
        db.addContact(cont);
        db.addContact(cont1);
        db.addContact(cont2);
        db.addContact(cont3);

        Log.d("MrKap", "All data are inserted..!!");

////        Update Contact
//        cont.setId(14);
//        cont.setName("Changed to Mr. Bean");
//        cont.setPhoneNumber("00000000000");
//        int affectedRows = db.updateContact(cont);
//        Log.d("MrKap", "No. of affected rows: "+affectedRows);
//
////       Delete contact by id
//        db.deleteContactById(1);
//        db.deleteContactById(2);
//        db.deleteContactById(3);
//        db.deleteContactById(4);

//        Delete contact by name

//      Display in list view
        ArrayList<String> contacts = new ArrayList<>();
        listView = findViewById(R.id.listView);

//        Get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for(Contact contact : allContacts){
//            Log.d("MrKap", "Id: "+contact.getId()+ " \n"+
//                    "Name: "+contact.getName()+ " \n"+
//                    "Phone Number: "+contact.getPhoneNumber());
            contacts.add(contact.getName() + " : " + contact.getPhoneNumber());
//            if(contact.getName()!=null && contact.getName()!=null) {
//                contacts.add(contact.getName() + " : " + contact.getPhoneNumber());
//            }
//            else{
//                contacts.add("Null Item here");
//            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);

//        Count
//        Log.d("MrKap", "Bro, You have "+ db.getCount() + " number of contacts in your db.");
    }
}