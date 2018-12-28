package com.example.android.untroddentestproject.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.untroddentestproject.R;
import com.example.android.untroddentestproject.Adapters.HistoryRVAdapter;
import com.example.android.untroddentestproject.RealmModels.History;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;


/**
 * A simple {@link Fragment} subclass.
 */
public class OTPDetailFragment extends Fragment {


    private RecyclerView recyclerView;
    private HistoryRVAdapter historyRVAdapter;

    public OTPDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_otpdetail, container, false);

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Realm realm = Realm.getDefaultInstance();

        final RealmResults<History> history = realm.where(History.class).findAll().sort("time",Sort.DESCENDING);

        historyRVAdapter = new HistoryRVAdapter(history);

        recyclerView.setAdapter(historyRVAdapter);

        return v;
    }

}
