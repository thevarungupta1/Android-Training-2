package com.example.recyclerviewproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewproject.R;
import com.example.recyclerviewproject.models.Post;

import java.util.ArrayList;

public class AdapterPostGrid extends RecyclerView.Adapter<AdapterPostGrid.MyViewHolder> {

    LayoutInflater layoutInflater;
    Context mContext;
    ArrayList<Post> mList = new ArrayList<>();

    public AdapterPostGrid(Context context){
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setAdapterData(ArrayList<Post> list){
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.row_recycler_view_grid, viewGroup, false);
        //MyViewHolder holder = new MyViewHolder(view);
        //return holder;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Post post = mList.get(i);
        myViewHolder.imageView.setImageResource(post.getImage());
        myViewHolder.textView.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
