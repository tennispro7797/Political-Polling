package com.example.adityamohile.politicalpolling;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class PollSelectFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rv;
    SwipeRefreshLayout swipeLayout;
    private int addCounter = 10;
    final ArrayList<String> myValues = new ArrayList<String>();
    final ArrayList<String> descrips = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Populate the ArrayLists
        for(int i = 0; i < 10; i++) {
            myValues.add("Poll Question " + i);
            descrips.add("Poll Description " + i);
        }
        View rootView = inflater.inflate(R.layout.activity_poll_select,null);


        //REFERENCE
        rv = (RecyclerView) rootView.findViewById(R.id.pollViewList);

        //LAYOUT MANAGER
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        //ADAPTER
        rv.setAdapter(new RecyclerViewAdapter(getActivity(),myValues, descrips));

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), rv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //Toast.makeText(MainActivity.this, myValues.get(position) + " " + descrips.get(position), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(),AnswerPollActivity.class);
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myValues.add(0, "Poll Question " + addCounter);
                descrips.add(0, "Poll Description " + addCounter);
                addCounter++;
                rv.setAdapter(new RecyclerViewAdapter(getActivity(),myValues, descrips));
                swipeLayout.setRefreshing(false);
            }
        }, 1500);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Poll");
    }
}
