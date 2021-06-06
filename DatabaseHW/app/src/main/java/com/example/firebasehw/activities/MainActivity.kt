package com.example.firebasehw.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.firebasehw.R
import com.example.firebasehw.fragments.BookFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //goToFragment()
        goToDatabaseActivity()
    }

    private fun goToDatabaseActivity(){
        var intent = Intent(this, LocalDatabaseActivity::class.java)
        startActivity(intent)
    }

    private fun goToFragment(){
        val setup = BookFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, setup)
        fragmentTransaction.commit()
    }
}