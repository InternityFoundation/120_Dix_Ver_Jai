package com.example.maternity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maternity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabySitterFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_baby_sitter, container, false);
    }

}
