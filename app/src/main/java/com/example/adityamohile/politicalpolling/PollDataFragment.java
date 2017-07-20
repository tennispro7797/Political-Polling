package com.example.adityamohile.politicalpolling;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class PollDataFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView rv;
    SwipeRefreshLayout swipeLayout;
    private int addCounter;
    final ArrayList<String> index = new ArrayList<String>();
    final ArrayList<String> data = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Populate the ArrayLists

        SharedPreferences sharedPrefs = this.getActivity().getSharedPreferences("myPrefs2", MODE_PRIVATE);
        addCounter = sharedPrefs.getInt("numDataPosts",10);

        for(int i = addCounter; i > 0; i--) {
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

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), rv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //Toast.makeText(MainActivity.this, myValues.get(position) + " " + descrips.get(position), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(),ViewPollDataActivity.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeContainer);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_red_dark),
                getResources().getColor(android.R.color.holo_blue_dark),
                getResources().getColor(android.R.color.holo_orange_dark));

        return rootView;
    }

    @Override
    public void onRefresh() {

        final Activity blip = this.getActivity();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addCounter++;
                index.add(0, "Poll Index " + addCounter);
                data.add(0, "Poll Data " + addCounter);

                SharedPreferences prefs = blip.getSharedPreferences("myPrefs2", MODE_PRIVATE);
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putInt("numDataPosts",addCounter);
                prefEditor.commit();

                rv.setAdapter(new RecyclerViewAdapter(getActivity(),index, data));
                swipeLayout.setRefreshing(false);
            }
        }, 1500);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Poll Data");
    }
}
