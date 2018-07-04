package com.thevarungupta.asyntask;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button;
ProgressBar progressBar;
EditText editTime;
TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

progressBar = findViewById(R.id.progress);
        button = findViewById(R.id.button);
        editTime = findViewById(R.id.edit);
        result = findViewById(R.id.text_view);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String time = editTime.getText().toString();
               new TaskRun().execute(time);

            }
        });
    }
   public class TaskRun extends AsyncTask<String, Void, Void>{

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           result.setText("Task Started");
       }

       @Override
       protected Void doInBackground(String... params) {
           try {
               int time = Integer.parseInt(params[0]);
               Thread.sleep(time);

           } catch (InterruptedException e) {
               e.printStackTrace();

           }
           return null;
       }

       @Override
       protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
           progressBar.setVisibility(View.GONE);
           result.setText("Task COmpleted");
       }
   }



}
