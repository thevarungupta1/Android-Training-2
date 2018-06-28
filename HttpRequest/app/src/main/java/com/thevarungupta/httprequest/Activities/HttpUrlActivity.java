package com.thevarungupta.httprequest.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thevarungupta.httprequest.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url);

        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData();
            }
        });
    }

    private void fetchData() {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("https://api.myjson.com/bins/wn4jy");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);
            BufferedReader bufReader = new BufferedReader(isw);

            // Read line of text from server response.
            String line = bufReader.readLine();
            StringBuffer readTextBuf = new StringBuffer();

            // Loop while return line is not null.
            while(line != null)
            {
                // Append the text to string buffer.
                readTextBuf.append(line);

                // Continue to read text line.
                line = bufReader.readLine();
                textView.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
