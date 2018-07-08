package com.thevarungupta.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveDataActivity extends AppCompatActivity {


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

//        databaseReference = FirebaseDatabase.getInstance().getReference("copyright");
//
//        databaseReference.setValue("©2016 androidhive. All rights Reserved");


        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        String id = databaseReference.push().getKey();

        User user = new User(id, "user 2", "user2@email.com");
        databaseReference.child(id).setValue(user);

        Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();

    }

    private void generateData(){
        User user;

        databaseReference = FirebaseDatabase.getInstance().getReference("users");


        String id = databaseReference.push().getKey();
        user = new User();
        user.setId(id);
        user.setName("n");
        databaseReference.child(id).setValue(user);

        String id = databaseReference.push().getKey();
        user = new User();
        user.setId(id);
        user.setName("n");
        databaseReference.child(id).setValue(user);

        String id = databaseReference.push().getKey();
        user = new User();
        user.setId(id);
        user.setName("n");
        databaseReference.child(id).setValue(user);
    }


}
