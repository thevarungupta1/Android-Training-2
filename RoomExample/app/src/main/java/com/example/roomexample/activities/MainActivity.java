package com.example.roomexample.activities;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.roomexample.R;
import com.example.roomexample.database.MyAppDatabase;
import com.example.roomexample.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!=null){
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }

    }
}
