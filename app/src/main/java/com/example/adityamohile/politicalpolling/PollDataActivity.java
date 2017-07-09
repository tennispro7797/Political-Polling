package com.example.adityamohile.politicalpolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PollDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_data);

//        final ArrayList<String> index = new ArrayList<String>();
//        final ArrayList<String> data = new ArrayList<String>();
//
//        //Populate the ArrayLists
//        for(int i = 0; i < 10; i++) {
//            index.add("Poll Index " + i);
//            data.add("Poll Data " + i );
//        }
//
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(index, data);
//        RecyclerView myView =  (RecyclerView)findViewById(R.id.pollDataList);
//        myView.setHasFixedSize(true);
//        myView.setAdapter(adapter);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        myView.setLayoutManager(llm);


    }
}
