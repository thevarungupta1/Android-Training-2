package com.thevarungupta.listviewwithcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox selectAllCheck;
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<Device> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To generate random list data which can be replace with actual data
        generateList();

        selectAllCheck = findViewById(R.id.check_box_all);

        // attaching onChecked change listener to check or uncheck
        selectAllCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // Creating a function to checked all checkbox in listview
                //checkedAll(b);
            }
        });

        listView = findViewById(R.id.list_view);
        customAdapter = new CustomAdapter(this, list);
        listView.setAdapter(customAdapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                Device device = list.get(i);
                if (device.isSelected()) {
                    device.setSelected(false);
                } else {
                    device.setSelected(true);
                }
                list.set(i, device);
                Toast.makeText(MainActivity.this, ""+device.getName()+""+device.isSelected(), Toast.LENGTH_SHORT).show();
                customAdapter.updateCheckbox(list);
            }
        });
    }

    private void checkedAll(boolean b) {
        if (b) {
            for (int i = 0; i < list.size(); i++) {
                Device device = list.get(i);
                device.setSelected(true);
                list.set(i, device);

            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                Device device = list.get(i);
                device.setSelected(false);
                list.set(i, device);

            }
            customAdapter.notifyDataSetChanged();
        }
    }

    private void generateList() {
        list = new ArrayList<>();
        list.add(new Device("Item 1", false));
        list.add(new Device("Item 2", true));
        list.add(new Device("Item 3", false));
        list.add(new Device("Item 4", false));
        list.add(new Device("Item 5", false));
    }
}
