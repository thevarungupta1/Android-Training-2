package com.thevarungupta.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1, button2, button3;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        imageButton = findViewById(R.id.image_button);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        imageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                Toast.makeText(this, "Button 1 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_2:
                Toast.makeText(this, "Button 2 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_3:
                Toast.makeText(this, "Button 3 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_button:
                Toast.makeText(this, "Image Button is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
