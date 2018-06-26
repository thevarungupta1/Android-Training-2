package com.thevarungupta.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleListActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.text_view_list);
        listItem = getResources().getStringArray(R.array.technology);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row_simple_layout, R.id.text_view_list, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapter.getItem(i);
                Toast.makeText(SimpleListActivity.this, "item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
