package com.example.fa.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fa.R
import com.example.fa.fragments.F2A2
import com.example.fa.fragments.F3A2
import com.example.fa.interfaces.ActivityFragmentCommunication


class A2 : AppCompatActivity(),ActivityFragmentCommunication{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a2)

        addF2A2()
    }

    override fun openActivity2() {
        TODO("Not yet implemented")
    }

    override fun replaceF2A2() {

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val tag = F3A2::class.java.name
        val replaceTransaction = transaction.replace(
            R.id.frame , F3A2.newInstance("",""), tag
        )

        replaceTransaction.commit()
    }

    override fun addF2A2() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val tag = F2A2::class.java.name
        val addTransaction = transaction.add(
            R.id.frame, F2A2.newInstance(), tag
        )
        addTransaction.commit()

    }


}