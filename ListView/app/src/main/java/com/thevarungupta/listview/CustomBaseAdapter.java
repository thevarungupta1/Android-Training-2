package com.thevarungupta.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> list;

    public CustomBaseAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_custom_layout, viewGroup, false);
        }
        // get current item to be displayed
        Item item = (Item) getItem(i);

        // get the TextView for item title and item description
        TextView textViewItemName = view.findViewById(R.id.text_view_title);
        TextView textViewItemDescription = view.findViewById(R.id.text_view_description);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(item.getTitle());
        textViewItemDescription.setText(item.getDescription());

        // returns the view for the current row
        return view;
    }
}
