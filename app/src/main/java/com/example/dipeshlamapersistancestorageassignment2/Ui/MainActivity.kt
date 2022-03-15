package com.example.dipeshlamapersistancestorageassignment2.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.dipeshlamapersistancestorageassignment2.R
import com.example.dipeshlamapersistancestorageassignment2.Utils.PreferenceUtils
import com.example.dipeshlamapersistancestorageassignment2.Utils.PreferencesConstants
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener(){
        btnLogout.setOnClickListener(this)
        btnWriteToInternal.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btnLogout -> {
                logOut()
            }
            btnWriteToInternal ->{
                startActivity(Intent(this, ReadWriteActivity::class.java))
            }
        }
    }

    // Function to set shared preferences value to empty
    private fun logOut (){
        PreferenceUtils.saveToPreference(this,"","")
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}