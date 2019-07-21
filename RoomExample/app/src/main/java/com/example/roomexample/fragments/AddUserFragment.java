package com.example.roomexample.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomexample.R;
import com.example.roomexample.activities.MainActivity;
import com.example.roomexample.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment implements View.OnClickListener {

    EditText editId, editName, editEmail;
    Button buttonSave;


    public AddUserFragment() {
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
        buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = Integer.parseInt(editId.getText().toString());
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        MainActivity.myAppDatabase.myDao().addUser(user);
        Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

        editId.setText("");
        editName.setText("");
        editEmail.setText("");

    }
}
