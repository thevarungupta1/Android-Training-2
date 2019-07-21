package com.example.sqlitecrudoperation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlitecrudoperation.R;
import com.example.sqlitecrudoperation.model.Post;

public class ListViewDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewTitle, textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_detail);

        init();
    }

    private  void init(){
        imageView = findViewById(R.id.image_view);
        textViewTitle = findViewById(R.id.text_view_title);
        textViewDescription = findViewById(R.id.text_view_description);

        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra("DATA");
         textViewTitle.setText(post.getTitle());
        textViewDescription.setText(post.getDescription());
        imageView.setImageResource(post.getImage());
    }
}
