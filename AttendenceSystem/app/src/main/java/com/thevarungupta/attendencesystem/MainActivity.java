package com.thevarungupta.attendencesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button generateBtn, shareBtn;
    TextView showOtpTextView;
    int otp;

    // declaring firebase reference
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initializing firebase database it will create a new table otp and store it reference in databaseRefernce object
//        which we can use for querying database
        databaseReference = FirebaseDatabase.getInstance().getReference("otp");

        showOtpTextView = findViewById(R.id.text_view_otp);
        generateBtn = findViewById(R.id.button_generate_otp);
        shareBtn = findViewById(R.id.button_share_otp);

        generateBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_generate_otp:
                generateOtp();
                break;
            case R.id.button_share_otp:
                saveAndShareOtp();
                break;
        }
    }

    private void generateOtp() {
        Random random = new Random();
        otp = random.nextInt(9000) + 1000;
        showOtpTextView.setText(String.valueOf(otp));
    }

    private void saveAndShareOtp() {
        String id = databaseReference.push().getKey();
        databaseReference.setValue(otp);
        startActivity(new Intent(this, VerifyActivity.class));
    }


}
