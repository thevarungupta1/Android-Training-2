package com.thevarungupta.attendencesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VerifyActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    EditText editOtp;
    Button subMItButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        editOtp = findViewById(R.id.edit_otp);
        subMItButton = findViewById(R.id.button_submit);
        subMItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify();
            }
        });
    }

    private void verify() {
        databaseReference.child("otp").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String otpFromDatabase = dataSnapshot.getValue().toString();

                String otp = editOtp.getText().toString();

                if(otp.equals(otpFromDatabase)){
                    Toast.makeText(VerifyActivity.this, "You have marked present successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(VerifyActivity.this, "Oops! Failed please try again", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
