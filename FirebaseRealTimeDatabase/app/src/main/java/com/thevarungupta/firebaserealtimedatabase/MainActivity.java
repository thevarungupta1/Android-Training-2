package com.thevarungupta.firebaserealtimedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit;
    Spinner genresSpinner;
    Button addButton;

    DatabaseReference databaseArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtist = FirebaseDatabase.getInstance().getReference("artists");
        String id = databaseArtist.push().getKey();
        //databaseArtist.setValue()

        nameEdit = findViewById(R.id.edit_text_name);
        addButton = findViewById(R.id.button_add);
        genresSpinner = findViewById(R.id.spinner);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addArtist();
            }
        });
    }

    private void addArtist() {
        String name = nameEdit.getText().toString();
        String genre = genresSpinner.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){
            String id = databaseArtist.push().getKey();
            Artist artist = new Artist(id, name, genre);
            databaseArtist.child(id).setValue(artist);
            Toast.makeText(this, "Artist Added", Toast.LENGTH_SHORT).show();
        }

    }
}
