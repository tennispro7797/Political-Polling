package com.example.adityamohile.politicalpolling;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PollDataFragment extends Fragment {

    private RecyclerView rv;
    final ArrayList<String> index = new ArrayList<String>();
    final ArrayList<String> data = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Populate the ArrayLists
        for(int i = 0; i < 10; i++) {
            index.add("Poll Index " + i);
            data.add("Poll Data " + i);
        }
        View rootView = inflater.inflate(R.layout.activity_poll_data,null);


        //REFERENCE
        rv = (RecyclerView) rootView.findViewById(R.id.pollDataList);

        //LAYOUT MANAGER
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        //ADAPTER
        rv.setAdapter(new RecyclerViewAdapter(getActivity(),index,data));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Poll Data");
    }
}
