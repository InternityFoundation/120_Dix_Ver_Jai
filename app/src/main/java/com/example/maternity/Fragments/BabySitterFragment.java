package com.example.maternity.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maternity.NannyDetails;
import com.example.maternity.R;
import com.example.maternity.RecyclerAdapterForBabysitterNearMe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabySitterFragment extends Fragment {
    private RecyclerAdapterForBabysitterNearMe recyclerAdapter;



    public BabySitterFragment() {
        // Required empty public constructor
    }

    public static BabySitterFragment newInstance(String param1, String param2) {
        BabySitterFragment fragment = new BabySitterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_baby_sitter, container, false);


        final RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("USERS").child("NANNY");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<NannyDetails> nannyDetailsArrayList = new ArrayList<NannyDetails>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                   // GenericTypeIndicator<NannyDetails> t = new GenericTypeIndicator<NannyDetails>() {};
                    NannyDetails nannyDetails = dataSnapshot1.getValue(NannyDetails.class);
                    nannyDetailsArrayList.add(nannyDetails);
                    Log.d("TAG", "onDataChange: "+nannyDetails.getPhone());

                }
//                GenericTypeIndicator<ArrayList<NannyDetails>> t = new GenericTypeIndicator<ArrayList<NannyDetails>>() {
//                };

//                nannyDetailsArrayList = dataSnapshot.getValue(t);
                Log.d("TAG", "onDataChange: "+nannyDetailsArrayList.size());
                recyclerAdapter=new RecyclerAdapterForBabysitterNearMe(nannyDetailsArrayList, getActivity().getApplicationContext());
                recyclerAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }

}
