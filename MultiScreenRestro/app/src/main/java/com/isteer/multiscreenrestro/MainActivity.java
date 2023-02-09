package com.isteer.multiscreenrestro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button;
    public static final String MSG = "com.isteer.multiscreenrestro.ORDER";
    public static final String RSP = "com.isteer.multiscreenrestro.RECEIVED";
    private int intLayout = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent1 = getIntent();
        String responsed = intent1.getStringExtra(RSP);
//        Set text inside textview to message for response fragment
        TextView textV = findViewById(R.id.intentView_response);
        textV.setText(responsed);
    }

    public  void placeOrder(View view){
        Intent intent = new Intent(this,OrderActivity.class);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String item1 = editText1.getText().toString();
                String item2 = editText2.getText().toString();
                String item3 = editText3.getText().toString();

                boolean check = validateInfo(item1, item2, item3);
                if(check==true){
                    Toast.makeText(getApplicationContext(), "Order Submitted Sccessfully", Toast.LENGTH_SHORT).show();
                    String order = "Your Order for "+item1+" , "+item2+" & "+item3+" has been placed Successfully🍽.";
                    intent.putExtra(MSG,order);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please write your order first.!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateInfo(String item1, String item2, String item3){
        if(item1.length()==0){
            editText1.requestFocus();
            editText1.setError("Field cannot be empty.!!");
            return false;
        }
        else if(item2.length()==0){
            editText2.requestFocus();
            editText2.setError("Field cannot be empty.!!");
            return false;
        }
        else if(item3.length()==0){
            editText3.requestFocus();
            editText3.setError("Field cannot be empty.!!");
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public void onBackPressed(){
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
            super.onBackPressed();
    }
}