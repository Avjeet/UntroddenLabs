package com.example.android.untroddentestproject.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.untroddentestproject.R;
import com.example.android.untroddentestproject.RealmModels.History;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmResults;

/**
 * Created by Your name on 28-12-2018.
 */
public class HistoryRVAdapter extends RecyclerView.Adapter<HistoryRVAdapter.MyViewHolder> {

    String pattern = "yyyy-MM-dd hh:mm";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private RealmResults<History> arrayList;

    public HistoryRVAdapter(RealmResults<History> arrayList) {
        this.arrayList = arrayList;


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
        myViewHolder.timeTv.setText(simpleDateFormat.format(new Date(arrayList.get(i).getTime())));
        myViewHolder.contactTv.setText(arrayList.get(i).getContact());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView contactTv;
        TextView timeTv;

        public MyViewHolder(View itemView){
            super(itemView);
            contactTv = itemView.findViewById(R.id.contact);
            timeTv = itemView.findViewById(R.id.name);
        }
    }
}
