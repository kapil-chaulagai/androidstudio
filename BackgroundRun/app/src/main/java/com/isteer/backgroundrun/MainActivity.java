package com.isteer.backgroundrun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public class Background extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("Kaps", "onPreExecute: Just Ran!");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("Kaps", "onPostExecute: Just Ran!");
            Log.d("Kaps", s);
        }

        @Override
        protected String doInBackground(String... urls) {
            Log.d("Kaps", "doInBackground: Is Running..!");
            String result = "";
            URL url;
            HttpURLConnection conn;
            try{
                url = new URL(urls[0]);
                conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data!=-1){
                    char current = (char) data;
                    result+=current;
                    data = reader.read();
                }
            }
            catch (Exception e){
                e.printStackTrace();
                return "Something went wrong!!";
            }
            return result;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Background myTask = new Background();
        myTask.execute("https://www.codewithharry.com/");
    }
    public void lelo(View view){
        Toast.makeText(this,"Selfie maine Le Liyaa..!!", Toast.LENGTH_SHORT).show();
    }
}