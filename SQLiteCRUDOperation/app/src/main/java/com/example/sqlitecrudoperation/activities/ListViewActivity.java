package com.example.sqlitecrudoperation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlitecrudoperation.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        generateData();
        init();
    }

    private void init(){
        listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row_list_view, R.id.text_view,mList );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, ""+mList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateData(){
        mList = new ArrayList<>();
        mList.add("A");
        mList.add("B");
        mList.add("C");
        mList.add("D");
        mList.add("E");
        mList.add("F");
        mList.add("G");
        mList.add("H");
        mList.add("I");
        mList.add("J");
    }
}
