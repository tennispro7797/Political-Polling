package com.example.adityamohile.politicalpolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PollSelectActivity extends AppCompatActivity {

    private final String[] pollsToSelect = {"Poll 1", "Poll 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_select);
        ListView pollList = (ListView) findViewById(R.id.pollSelectList);
        ArrayAdapter<String> pollSelectAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                pollsToSelect
        );
        pollList.setAdapter(pollSelectAdapter);
        pollList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = Toast.makeText(getApplicationContext(), pollsToSelect[i], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
