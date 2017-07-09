package com.example.adityamohile.politicalpolling;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context c;
    public ArrayList<String> myValues;
    public ArrayList<String> descriptions;
    public RecyclerViewAdapter(Context c, ArrayList<String> myValues, ArrayList<String> descriptions){
        this.c = c;
        this.myValues= myValues;
        this.descriptions = descriptions;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.myTextView.setText(myValues.get(position));
        holder.descriptionView.setText(descriptions.get(position));
    }


    @Override
    public int getItemCount() {
        return myValues.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView myTextView;
        private TextView descriptionView;
        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView)itemView.findViewById(R.id.text_cardview);
            descriptionView = (TextView)itemView.findViewById(R.id.text_description);
        }
    }
}
