package com.thevarungupta.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    Item item;
    ListView listView;
    ArrayList<Item> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        mList = SampleData.generateData();
        listView = findViewById(R.id.list_view);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, mList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = mList.get(i);
                Toast.makeText(CustomListActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
