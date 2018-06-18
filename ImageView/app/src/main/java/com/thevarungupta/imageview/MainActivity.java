package com.thevarungupta.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button switchButton;
    ImageView imageView;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        switchButton = findViewById(R.id.button);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchImage();
            }
        });
    }

    private void switchImage() {
        if (flag == 0) {
            imageView.setImageResource(R.drawable.marshmallow);
            flag = 1;
        } else {
            imageView.setImageResource(R.drawable.lollipop);
            flag = 0;
        }
    }
}
