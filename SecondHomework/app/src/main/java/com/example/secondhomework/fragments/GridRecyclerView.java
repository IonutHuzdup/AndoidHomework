package com.example.secondhomework.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secondhomework.R;
import com.example.secondhomework.adapters.JobAdapter;
import com.example.secondhomework.models.Job;

import java.util.ArrayList;

public class GridRecyclerView extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ArrayList<Job> jobs;
    private JobAdapter adapter;

    public GridRecyclerView() {
        // Required empty public constructor
    }

    public static GridRecyclerView newInstance(String param1, String param2) {
        GridRecyclerView fragment = new GridRecyclerView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_recycler_view, container, false);
        recyclerView = view.findViewById(R.id.grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new JobAdapter(jobs);
        jobs.add(new Job("1", "1", "1", "1", "1"));
        jobs.add(new Job("1", "1", "1", "1", "1"));
        jobs.add(new Job("1", "1", "1", "1", "1"));
        recyclerView.setAdapter(adapter);


        return view;
    }
}