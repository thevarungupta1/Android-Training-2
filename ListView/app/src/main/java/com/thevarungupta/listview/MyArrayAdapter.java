package com.thevarungupta.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MyArrayAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] mTitles;
    private String[] mDescriptions;
    private Integer[] mImagesId;

    public MyArrayAdapter(Context context, String[] titles, String[] description, Integer[] imagesId) {
        super(context, R.layout.row_custom_layout);
        this.context = context;
        this.mTitles = titles;
        this.mDescriptions = description;
        this.mImagesId = imagesId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);

    }
}
