package com.example.roomexample.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomexample.R;
import com.example.roomexample.activities.MainActivity;
import com.example.roomexample.model.User;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_read_user, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        textView = view.findViewById(R.id.text_view);
        List<User> users=  MainActivity.myAppDatabase.myDao().getUsers();

        String info = "";

        for(User user : users){
            info = info + "\n\n Id: "+user.getId()+", Name:"+user.getName()+", Email:"+ user.getEmail();
        }
        textView.setText(info);
    }

}
