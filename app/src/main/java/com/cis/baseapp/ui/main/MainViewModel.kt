package com.cis.baseapp.ui.main

import androidx.lifecycle.ViewModel
import com.cis.baseapp.data.AppDataManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val appDataManager: AppDataManager) : ViewModel()  {
}