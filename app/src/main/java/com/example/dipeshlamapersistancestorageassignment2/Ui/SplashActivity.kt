package com.example.dipeshlamapersistancestorageassignment2.Ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.dipeshlamapersistancestorageassignment2.R
import com.example.dipeshlamapersistancestorageassignment2.Utils.PreferenceUtils
import com.example.dipeshlamapersistancestorageassignment2.Utils.PreferencesConstants

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashDelayHandler()
    }

    private fun splashDelayHandler(){
        val activity : Activity= checkLoggedIn()
        Handler().postDelayed({
            startActivity(Intent(this, activity::class.java))
            finish()
        },2000)
    }

    private fun checkLoggedIn() : Activity {
        val email = PreferenceUtils.getEmailFromPreferences(this)
        val password = PreferenceUtils.getPasswordFromPreferences(this)

        return if(email.isEmpty()  && password.isEmpty()){
            LoginActivity()
        } else{
            MainActivity()
        }
    }
}