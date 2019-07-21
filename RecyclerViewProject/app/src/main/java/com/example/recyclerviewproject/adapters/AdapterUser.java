package com.example.recyclerviewproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewproject.R;
import com.example.recyclerviewproject.models.User;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyViewHolder> {

    ArrayList<User> mList = new ArrayList<>();
    Context mContext;

    public AdapterUser(Context context, ArrayList<User> list){
        this.mContext = context;
        this.mList = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_user, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        User user = mList.get(i);
        myViewHolder.textViewName.setText(user.getName());
        myViewHolder.textViewPhone.setText(user.getPhone());
        myViewHolder.textViewEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName, textViewPhone, textViewEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPhone = itemView.findViewById(R.id.text_phone);
            textViewEmail = itemView.findViewById(R.id.text_email);
        }
    }
}
