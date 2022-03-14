package com.example.dipeshlamapersistancestorageassignment2.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dipeshlamapersistancestorageassignment2.R
import com.example.dipeshlamapersistancestorageassignment2.Utils.PreferenceUtils
import com.example.dipeshlamapersistancestorageassignment2.Utils.PreferencesConstants
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListener()
    }

    private fun initListener (){
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view){
            btnLogin ->{
                savePreferences()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun savePreferences () {
        val email = edtEmail.text.toString()
        val password = edtPassword.text.toString()
        PreferenceUtils.saveToPreference(this, email,password)
    }

//    private fun savePreferences () {
//        val email = edtEmail.text.toString()
//        val password = edtPassword.text.toString()
//        val sharedPref = getSharedPreferences(PreferencesConstants.loginPreferences, MODE_PRIVATE)
//        val editor= sharedPref.edit()
//        editor.putString(PreferencesConstants.email,email)
//        editor.putString(PreferencesConstants.password,password)
//        editor.putBoolean(PreferencesConstants.isLoggedIn,true)
//        editor.apply()
//    }
}