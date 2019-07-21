package com.example.roomexample.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roomexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {

    EditText editId, editName, editEmail;
    Button buttonSave;
    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        editId = view.findViewById(R.id.edit_text_id);
        editName = view.findViewById(R.id.edit_text_name);
        editEmail = view.findViewById(R.id.edit_text_email);
        buttonSave = view.findViewById(R.id.button_add);
        //buttonSave.setOnClickListener(this);
    }

}
