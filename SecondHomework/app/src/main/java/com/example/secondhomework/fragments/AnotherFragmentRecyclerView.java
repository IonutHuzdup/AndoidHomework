package com.example.secondhomework.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.secondhomework.R;
import com.example.secondhomework.adapters.EmployeeAdapter;
import com.example.secondhomework.adapters.JobAdapter;
import com.example.secondhomework.interfaces.OnCellClick;
import com.example.secondhomework.models.Employee;
import com.example.secondhomework.models.Job;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class AnotherFragmentRecyclerView extends Fragment implements OnCellClick {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ArrayList<Employee> employees;
    private EmployeeAdapter adapter;

    public AnotherFragmentRecyclerView() {
        // Required empty public constructor
    }

    public static AnotherFragmentRecyclerView newInstance(String param1, String param2) {
        AnotherFragmentRecyclerView fragment = new AnotherFragmentRecyclerView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance() {
        AnotherFragmentRecyclerView fragment = new AnotherFragmentRecyclerView();
        Bundle args = new Bundle();
        String param1 = null;
        args.putString(ARG_PARAM1, param1);
        String param2 = null;
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
        employees = new ArrayList<Employee>();
        View view = inflater.inflate(R.layout.fragment_another_recycler_view, container, false);
        recyclerView = view.findViewById(R.id.another_list);
        adapter = new EmployeeAdapter(employees, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        employees.add(new Employee("1", "1", "asd", "John", "asd", "5432"));
        employees.add(new Employee("1", "1", "asd", "John", "asd", "5432"));
        employees.add(new Employee("1", "1", "asd", "John", "asd", "5432"));
        employees.add(new Employee("1", "1", "asd", "John", "asd", "5432"));

        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "USer", LENGTH_SHORT).show();
        addFragment();
    }

    @Override
    public void addFragment() {
        GridRecyclerView gridRecyclerView = new GridRecyclerView();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String tag = GridRecyclerView.class.getName();
        fragmentTransaction.replace(R.id.grid_layout, gridRecyclerView, tag);
        fragmentTransaction.commit();
    }
}