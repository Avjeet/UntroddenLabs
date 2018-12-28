package com.example.android.untroddentestproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Your name on 28-12-2018.
 */
public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.MyViewHolder> {
    private final Context activity;
    private ArrayList<UTModel> arrayList;

    public ContactRVAdapter(ArrayList<UTModel> arrayList,Context context) {
        this.arrayList = arrayList;
        this.activity = context;

        Log.i("jsize",String.valueOf(arrayList.size()));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.nameTv.setText(arrayList.get(i).getName());
        myViewHolder.contactTv.setText(arrayList.get(i).getContact());
        myViewHolder.contactTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,OTPActivity.class);
                intent.putExtra("position",i);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv;
        TextView contactTv;

        public MyViewHolder(View itemView){
            super(itemView);
            contactTv = itemView.findViewById(R.id.contact);
            nameTv = itemView.findViewById(R.id.name);
        }
    }
}
