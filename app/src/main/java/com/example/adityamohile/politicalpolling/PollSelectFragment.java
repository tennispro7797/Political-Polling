package com.example.adityamohile.politicalpolling;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class PollSelectFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, AsyncResponse {

    private RecyclerView rv;
    SwipeRefreshLayout swipeLayout;
    private int addCounter;
    private PostResponseAsyncTask getPolls;
    final ArrayList<String> myValues = new ArrayList<String>();
    final ArrayList<String> descrips = new ArrayList<String>();
    ArrayList<Integer> pollIDs = new ArrayList<>();
    private ArrayList<Polls> polls;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Populate the ArrayLists

        Log.v("lifecycle","CREATE VIEW");
        getPolls = new PostResponseAsyncTask(getActivity(), this);
        getPolls.execute("http://10.0.2.2/readQuestions.php");
        View rootView = inflater.inflate(R.layout.activity_poll_select,null);


        //REFERENCE
        rv = (RecyclerView) rootView.findViewById(R.id.pollViewList);

        //LAYOUT MANAGER
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), rv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //Toast.makeText(MainActivity.this, myValues.get(position) + " " + descrips.get(position), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(),AnswerPollActivity.class);
                        intent.putExtra("question", myValues.get(position));
                        intent.putExtra("description",descrips.get(position));
                        intent.putExtra("id",pollIDs.get(position)+"");
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
                PostResponseAsyncTask getPollsAgain = new PostResponseAsyncTask(getActivity(), PollSelectFragment.this);
                getPollsAgain.execute("http://10.0.2.2/readQuestions.php");
                swipeLayout.setRefreshing(false);
            }
        }, 1500);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Poll");
    }

    @Override
    public void processFinish(String s) {
        if (polls == null) {
            Log.v("pollStatus","polls = null");
            polls = new JsonConverter<Polls>().toArrayList(s, Polls.class);
            for (int i = 0; i < polls.size(); i++) {
                myValues.add(polls.get(i).question);
                descrips.add(polls.get(i).description);
                pollIDs.add(polls.get(i).id);
            }
        } else if (polls != null) {
            Log.v("pollStatus","poll = "+polls.size());
            ArrayList<Polls> newPolls = new JsonConverter<Polls>().toArrayList(s, Polls.class);
            Log.v("pollStatus","newPolls = "+newPolls.size());
            for (int i = polls.size(); i < newPolls.size(); i++) {
                myValues.add(newPolls.get(i).question);
                descrips.add(newPolls.get(i).description);
                pollIDs.add(polls.get(i).id);
            }
            polls = newPolls;
        }
        //ADAPTER
        rv.setAdapter(new RecyclerViewAdapter(getActivity(),myValues, descrips));
    }
}
