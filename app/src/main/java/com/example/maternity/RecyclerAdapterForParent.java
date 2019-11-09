package com.example.maternity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerAdapterForParent extends RecyclerView.Adapter<RecyclerAdapterForParent.MyHolder> {



    ArrayList<DailyDetails> dailyDetails;
    Context context;
    public RecyclerAdapterForParent(ArrayList<DailyDetails> classDetails, Context context)
    {
        this.dailyDetails=classDetails;
        this.context=context;
    }
    @NonNull
    @Override
    public RecyclerAdapterForParent.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerviewforparent, parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterForParent.MyHolder holder, int position) {

        DailyDetails classlist=dailyDetails.get(position);
        holder.ageGroup.setText(classlist.ageGroup);
        holder.whatToFeed.setText(classlist.whatToFeed);
        holder.otherInfo.setText(classlist.otherInfo);
    }

    @Override
    public int getItemCount() {
        int arr=0;
        try {
            if(dailyDetails.size()==0)
            {
                arr=0;
            }else
            {
                arr=dailyDetails.size();
            }
        }catch (Exception ignored){

        }
        return arr;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView ageGroup, whatToFeed,otherInfo;
        MyHolder(View itemView) {
            super(itemView);
            ageGroup=itemView.findViewById(R.id.ageGroup);
            whatToFeed=itemView.findViewById(R.id.whatToFeed);
            otherInfo=itemView.findViewById(R.id.otherInfo);

        }
    }
}
