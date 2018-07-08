package com.thevarungupta.listviewwithcheckbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Device> mList;

    public CustomAdapter(Context context, ArrayList<Device> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // Custom adapter function which we use to update dataset
    public void updateCheckbox(ArrayList<Device> list){
        mList.clear();
        mList.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.row_list_view_layout, viewGroup, false);

        Device device = mList.get(i);
        TextView textView = view.findViewById(R.id.text_view_list);
        CheckBox checkBox = view.findViewById(R.id.check_box_list);

        if(device.isSelected()){
            checkBox.setChecked(!checkBox.isChecked());
        }else{
            checkBox.setChecked(checkBox.isChecked());
        }
        textView.setText(device.getName()+device.isSelected());




        return view;
    }

    class ViewHolder{

    }


}
