package com.example.adityamohile.politicalpolling;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class ViewPollDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_poll_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("View Poll Data");

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 32f));
        entries.add(new BarEntry(1f, 56f));

        BarDataSet set = new BarDataSet(entries,"Votes");
        set.setValueTextSize(20f);

        BarData data = new BarData(set);
        BarChart chart = new BarChart(this);
        Description desc = new Description();
        desc.setText("");
        chart.setDescription(desc);

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(20);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextSize(20f);

        YAxis yAxis2 = chart.getAxisRight();
        yAxis2.setTextSize(20f);

        data.setBarWidth(0.9f); // set custom bar width
        data.setValueTextSize(20f);
        chart.setData(data);
        chart.setMinimumHeight(1000);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        LinearLayout viewDataLayout = (LinearLayout) findViewById(R.id.viewData);
        viewDataLayout.addView(chart);
    }

}
