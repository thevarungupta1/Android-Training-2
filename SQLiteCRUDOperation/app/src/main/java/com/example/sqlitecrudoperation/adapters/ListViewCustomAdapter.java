package com.example.sqlitecrudoperation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitecrudoperation.R;
import com.example.sqlitecrudoperation.model.Post;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;

public class ListViewCustomAdapter extends BaseAdapter {

    Context mComtext;
    ArrayList<Post> mList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public ListViewCustomAdapter(Context context, ArrayList<Post> list){
        this.mComtext = context;
        this.mList = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class MyViewHolder{
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDescription;

        public MyViewHolder(View v){
            imageView = v.findViewById(R.id.image_view);
            textViewTitle = v.findViewById(R.id.text_view_title);
            textViewDescription = v.findViewById(R.id.text_view_description);
        }

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // layout inflation is avery expensive operation
        MyViewHolder holder = null;
        View view = convertView;

        if(view ==null){
            view = layoutInflater.inflate(R.layout.row_list_view_custom, parent, false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (MyViewHolder) view.getTag();

        }
        Post post = mList.get(position);
        holder.imageView.setImageResource(post.getImage());
        holder.textViewTitle.setText(post.getTitle());
        holder.textViewDescription.setText(post.getDescription());


        return view;
    }
}
