package com.example.maternity.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.maternity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorFragment extends Fragment {


    public DoctorFragment() {
        // Required empty public constructor
    }

    public static DoctorFragment newInstance(String param1, String param2) {
        DoctorFragment fragment = new DoctorFragment();
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
        return inflater.inflate(R.layout.fragment_doctor, container, false);
    }

}
