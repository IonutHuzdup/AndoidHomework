package com.example.fa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fa.R;
import com.example.fa.interfaces.ActivityFragmentCommunication;

public class A1 extends AppCompatActivity implements ActivityFragmentCommunication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
    }

    @Override
    public void openActivity2() {
        Intent intent = new Intent(this, A2.class);
        startActivity(intent);
    }

    @Override
    public void addF2A2() {

    }

    @Override
    public void replaceF2A2() {

    }
}