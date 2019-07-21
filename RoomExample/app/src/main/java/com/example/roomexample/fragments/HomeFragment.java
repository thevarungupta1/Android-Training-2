package com.example.roomexample.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.roomexample.R;
import com.example.roomexample.activities.MainActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    Button buttonInsert, buttonRead, buttonUpdate, buttonDelete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        buttonInsert = view.findViewById(R.id.button_insert);
        buttonRead = view.findViewById(R.id.button_read);
        buttonUpdate = view.findViewById(R.id.button_update);
        buttonDelete = view.findViewById(R.id.button_delete);

        buttonInsert.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_insert:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.button_read:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.button_update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.button_delete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;
        }

    }
}
