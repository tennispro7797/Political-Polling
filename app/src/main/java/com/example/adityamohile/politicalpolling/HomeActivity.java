package com.example.adityamohile.politicalpolling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToPollSelect(View view) {
        //Open PollSelectActivity
        Intent pollSelectIntent = new Intent(this, PollSelectActivity.class);
        startActivity(pollSelectIntent);
    }

    public void goToPollData(View view) {
        //Open PollDataActivity
        Intent pollDataIntent = new Intent(this, PollDataActivity.class);
        startActivity(pollDataIntent);
    }
}
