package com.example.adityamohile.politicalpolling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PollSelectActivity extends AppCompatActivity {

    private final String[] pollsToSelect = {"Poll 1", "Poll 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_select);

//        final ArrayList<String> myValues = new ArrayList<String>();
//        final ArrayList<String> descrips = new ArrayList<String>();
//
//        //Populate the ArrayList with your own values
//        myValues.add("Poll Question 1");descrips.add("Poll Description 1");
//        myValues.add("Poll Question 2");descrips.add("Poll Description 2");
//        myValues.add("Poll Question 3");descrips.add("Poll Description 3");
//        myValues.add("Poll Question 4");descrips.add("Poll Description 4");
//        myValues.add("Poll Question 5");descrips.add("Poll Description 5");
//        myValues.add("Poll Question 6");descrips.add("Poll Description 6");
//        descrips.add("Poll Question 7");descrips.add("Poll Description 7");
//
//
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(myValues, descrips);
//        RecyclerView myView =  (RecyclerView)findViewById(R.id.recyclerview);
//        myView.setHasFixedSize(true);
//        myView.setAdapter(adapter);
//        myView.addOnItemTouchListener(
//                new RecyclerItemClickListener(getApplicationContext(), myView, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override public void onItemClick(View view, int position) {
//                        // do whatever
//                        //Toast.makeText(MainActivity.this, myValues.get(position) + " " + descrips.get(position), Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(PollSelectActivity.this, AnswerPollActivity.class);
//                        startActivity(intent);
//                    }
//
//                    @Override public void onLongItemClick(View view, int position) {
//                        // do whatever
//                    }
//                })
//        );
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        myView.setLayoutManager(llm);
//        ListView pollList = (ListView) findViewById(R.id.pollSelectList);
//        ArrayAdapter<String> pollSelectAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                pollsToSelect
//        );
//        pollList.setAdapter(pollSelectAdapter);
//        pollList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast toast = Toast.makeText(getApplicationContext(), pollsToSelect[i], Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
    }
}
