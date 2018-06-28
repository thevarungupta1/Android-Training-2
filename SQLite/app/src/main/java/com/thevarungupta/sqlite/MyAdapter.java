package com.thevarungupta.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<User> list;
    Context context;

    public MyAdapter(Context context, ArrayList<User> list){
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
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.row_simple_layout, viewGroup, false);
        }

        User user = (User) getItem(i);

        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(user.getName());
        return view;
    }
}
