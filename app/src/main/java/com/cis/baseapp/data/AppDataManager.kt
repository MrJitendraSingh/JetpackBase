package com.cis.baseapp.data

import android.content.Context
import com.cis.baseapp.data.pref.AppPreferences
import javax.inject.Inject

class AppDataManager @Inject constructor(context: Context) : AppPreferences(context){

    @Inject
    lateinit var appPref: AppPreferences
}