package com.example.secondhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.secondhomework.adapters.Adapter
import com.example.secondhomework.fragments.FragmentRecyclerView
import com.example.secondhomework.models.User
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val setup = FragmentRecyclerView();
        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout,setup)
        fragmentTransaction.commit()

    }
}