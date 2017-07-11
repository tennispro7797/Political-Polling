package com.example.adityamohile.politicalpolling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Help");

        ListView faqList = (ListView) findViewById(R.id.faqList);

        String[] faqMaterial = {
                "Question 1", "Answer to Question 1",
                "Question 2", "Answer to Question 2",
                "Question 3", "Answer to Question 3",
                "Question 4", "Answer to Question 4",
                "Question 5", "Answer to Question 5",
                "Question 6", "Answer to Question 6",
        };
        
        List<HashMap<String,String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this,listItems,R.layout.list_item,
                new String[]{"First Line","Second Line"},
                new int[]{R.id.question, R.id.answer});

        for (int i = 0; i < faqMaterial.length-1; i+=2) {
            HashMap<String,String> resultsMap = new HashMap<>();
            resultsMap.put("First Line",faqMaterial[i]);
            resultsMap.put("Second Line",faqMaterial[i+1]);
            listItems.add(resultsMap);
        }

        faqList.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}