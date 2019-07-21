package com.example.sqlitecrudoperation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlitecrudoperation.R;
import com.example.sqlitecrudoperation.adapters.ListViewCustomAdapter;
import com.example.sqlitecrudoperation.model.Post;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listViewCustom;
    ArrayList<Post> list;
    ListViewCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        generateData();
        init();

    }

    private void init(){
        listViewCustom = findViewById(R.id.list_view_custom);
        adapter = new ListViewCustomAdapter(this, list);
        listViewCustom.setAdapter(adapter);
        listViewCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post post = list.get(position);
                Intent intent = new Intent(CustomListViewActivity.this, ListViewDetailActivity.class);
                intent.putExtra("DATA", post);
                //intent.putExtra("IMAGE", post);
//                intent.putExtra("TITLE", post.getTitle());
//                intent.putExtra("DESCRIPTION", post.getDescription());
                startActivity(intent);

            }
        });
    }

    private void generateData(){
        list = new ArrayList<>();
        Post post;

        post = new Post("Title 1", "Description 1", R.drawable.ic_add_alert_black_24dp);
        list.add(post);

        post = new Post("Title 2", "Description 2", R.drawable.ic_airline_seat_flat_angled_black_24dp);
        list.add(post);

        post = new Post("Title 3", "Description 3", R.drawable.ic_airplanemode_active_black_24dp);
        list.add(post);
    }
}
