package com.thevarungupta.asyntask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView finalResult;
    Button button;
    EditText time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finalResult = findViewById(R.id.text_view_result);
        time  =findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String sleepTime = time.getText().toString();
                TaskUpdate taskUpdate = new TaskUpdate();
                taskUpdate.execute(sleepTime);
            }
        });
    }

    private void blockUI(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class TaskUpdate extends AsyncTask<String, String, String>{

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Progress Dialoge");
            progressDialog.setMessage("Wait for "+time.getText().toString()+ " seconds");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping...");
            try {
                int time = Integer.parseInt(params[0])*100;
                Thread.sleep(time);
                resp = "Sleep for "+params[0]+" second";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            finalResult.setText(result);
        }

    }
}
