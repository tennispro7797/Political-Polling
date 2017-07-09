package com.example.adityamohile.politicalpolling;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PollSelectFragment extends Fragment {

    private RecyclerView rv;
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
                        Fragment fragment = new AnswerPollFragment();
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.commit();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        //int width = getResources().getDisplayMetrics().widthPixels/2;
        //RecyclerView.LayoutParams params = () mDrawerList.getLayoutParams();
        //params.width = width;
        //mDrawerList.setLayoutParams(params);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Poll");
    }
}
