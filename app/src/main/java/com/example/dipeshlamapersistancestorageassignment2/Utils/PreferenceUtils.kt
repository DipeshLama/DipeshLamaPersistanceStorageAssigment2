package com.example.dipeshlamapersistancestorageassignment2.Utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceUtils {

    private fun getPreferences (context : Context?): SharedPreferences?{
        return context?.getSharedPreferences(PreferencesConstants.loginPreferences,Context.MODE_PRIVATE)
    }

    fun saveToPreference (context: Context?,email:String, password:String){
        val editor = getPreferences(context)?.edit()
        editor?.putString(PreferencesConstants.email,email)
        editor?.putString(PreferencesConstants.password,password)
        editor?.apply()
    }

    fun getEmailFromPreferences (context: Context?) : String {
        return getPreferences(context)?.getString(PreferencesConstants.email,"")?: ""
    }

    fun getPasswordFromPreferences (context: Context?) : String {
        return getPreferences(context)?.getString(PreferencesConstants.password,"")?: ""
    }

//    fun checkBooleanFromPreferences (context: Context?) : Boolean{
//        return getPreferences(context)?.getBoolean(PreferencesConstants.isLoggedIn,PreferencesConstants.checkLoggedIn!!)!!
//    }

}