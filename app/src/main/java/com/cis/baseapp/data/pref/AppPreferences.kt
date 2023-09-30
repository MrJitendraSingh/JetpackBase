package com.cis.baseapp.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.cis.baseapp.util.Constant
import javax.inject.Inject

open class AppPreferences @Inject constructor(context: Context){

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(Constant.MY_PREF_NAME, Context.MODE_PRIVATE)

    fun setString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String = ""): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun clearPref() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

}