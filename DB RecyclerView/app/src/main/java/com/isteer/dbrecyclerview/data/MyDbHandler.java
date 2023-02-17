package com.isteer.dbrecyclerview.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.isteer.dbrecyclerview.model.Contact;
import com.isteer.dbrecyclerview.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE "+Params.TABLE_NAME+" ( "+Params.KEY_ID + " INTEGER PRIMARY KEY , "
                + Params.KEY_NAME + " TEXT , " + Params.KEY_PHONE + " TEXT " + ")" ;

        Log.d("MrKap","Query: " + create);
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME, null,values);
        Log.d("MrKap", "Successfully Inserted..!!");
        db.close();
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

//      Generate the query to read from the database
        String select = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

//        Loop through now
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

////    Update Contact
//    public int updateContact(Contact contact){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Params.KEY_NAME,contact.getName());
//        values.put(Params.KEY_PHONE, contact.getPhoneNumber());
//
////        update now
//        return  db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
//                new String[]{String.valueOf(contact.getId())});
//    }

//    Delete contact by id
//    public void deleteContactById(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID + "=?", new String[]{String.valueOf(id)});
//        db.close();
//    }

////    Delete contact by name/phone
//    public void deleteContact(Contact contact){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID + "=?", new String[]{String.valueOf(contact.getId())});
//        db.close();
//    }

//    Count
    public int getCount(){
        String query = "SELECT * FROM " + Params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }
}
