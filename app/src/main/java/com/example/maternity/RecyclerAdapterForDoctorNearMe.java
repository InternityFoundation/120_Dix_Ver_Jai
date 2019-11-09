package com.example.maternity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterForDoctorNearMe extends RecyclerView.Adapter<RecyclerAdapterForDoctorNearMe.MyHolder> {



        ArrayList<DoctorDetails> dailyDetails;
        Context context;
public RecyclerAdapterForDoctorNearMe(ArrayList<DoctorDetails> classDetails, Context context)
        {
        this.dailyDetails=classDetails;
        this.context=context;
        }
@NonNull
@Override
public RecyclerAdapterForDoctorNearMe.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerviewfordoctorsnearme, parent,false);
        return new MyHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RecyclerAdapterForDoctorNearMe.MyHolder holder, int position) {

        DoctorDetails classlist=dailyDetails.get(position);
        holder.username.setText(classlist.username);
        holder.phone.setText(classlist.phone);
        holder.permanentAddress.setText(classlist.permanentAddress);
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
    TextView username, phone,permanentAddress;
    MyHolder(View itemView) {
        super(itemView);
        username=itemView.findViewById(R.id.doctorName);
        phone=itemView.findViewById(R.id.phoneNumber);
        permanentAddress=itemView.findViewById(R.id.permanentAddress);

    }
}
}
