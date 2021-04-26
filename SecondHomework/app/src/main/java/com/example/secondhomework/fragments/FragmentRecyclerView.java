package com.example.secondhomework.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.secondhomework.MainActivity;
import com.example.secondhomework.R;
import com.example.secondhomework.VolleyConfigSingleton;
import com.example.secondhomework.adapters.Adapter;
import com.example.secondhomework.interfaces.OnCellClick;
import com.example.secondhomework.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static android.widget.Toast.LENGTH_SHORT;

public class FragmentRecyclerView extends Fragment implements OnCellClick {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ArrayList<User> users;
    private Adapter adapter;
    private RequestQueue requestQueue;
    private String id;
    private String createdAt;
    private String name;
    private String avatar;
    private String description;

    public FragmentRecyclerView() {

    }

    public static FragmentRecyclerView newInstance(String param1, String param2) {
        FragmentRecyclerView fragment = new FragmentRecyclerView();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        users = new ArrayList<User>();
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        recyclerView = view.findViewById(R.id.list);
        adapter = new Adapter(users, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));
        users.add(new User("1", "ads", "dave", "dsa", "man"));

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
        AnotherFragmentRecyclerView anotherFragmentRecyclerView = new AnotherFragmentRecyclerView();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String tag = AnotherFragmentRecyclerView.class.getName();
        fragmentTransaction.replace(R.id.frame_layout, anotherFragmentRecyclerView, tag);
        fragmentTransaction.commit();
    }
    /*
    public void getCompanies() {
        VolleyConfigSingleton volleyConfigSingleton = VolleyConfigSingleton.getInstance(getContext());
        requestQueue = volleyConfigSingleton.getRequestQueue();
        String url = "https://608305a05dbd2c001757b0a1.mockapi.io/api/companies";
        StringRequest getCompaniesRequest = new StringRequest(url, null,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Object company = jsonArray.get(i);
                                JSONObject com = (JSONObject) company;
                                String id = com.getString("id");
                                String createdAt = com.getString("createdAt");
                                String name = com.getString("name");
                                String avatar = com.getString("avatar");
                                String description = com.getString("description");
                                User user = new User(id, createdAt, name, avatar, description);
                                users.add(user);
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                    }

                }
        );

    }*/
}
