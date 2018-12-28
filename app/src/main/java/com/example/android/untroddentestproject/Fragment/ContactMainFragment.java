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
import com.example.android.untroddentestproject.Adapters.ContactRVAdapter;
import com.example.android.untroddentestproject.RealmModels.UTModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactMainFragment extends Fragment {

    private ContactRVAdapter contactRVAdapter ;
    private RecyclerView recyclerView;
    private Realm realm;

    public ContactMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_contact_main, container, false);

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
         realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(UTModel.class).findAll().deleteAllFromRealm();
        realm.commitTransaction();
        ArrayList<UTModel> a = new ArrayList<>();
        try {
            a = parseJSON();
        } catch (JSONException e) {
            e.printStackTrace();
        }

            contactRVAdapter = new ContactRVAdapter(a,this.getActivity());


        recyclerView.setAdapter(contactRVAdapter);

        return v;
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("contactData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private ArrayList<UTModel> parseJSON() throws JSONException {

        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray m_jArry = obj.getJSONArray("contacts");
        ArrayList<UTModel> contactList = new ArrayList<>();
        UTModel contactItem;

        realm.beginTransaction();

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = m_jArry.getJSONObject(i);

            String name = jo_inside.getString("name");
            String contact = jo_inside.getString("number");
            String gender = jo_inside.getString("gender");
            String address = jo_inside.getString("address");

            //Add your values in your `ArrayList` as below:
            contactItem = new UTModel(i,name,contact,address,gender);

            realm.copyToRealm(contactItem);

            contactList.add(contactItem);
        }
        realm.commitTransaction();
        return contactList;
    }
}
