package com.cis.baseapp.ui.main.home

import androidx.lifecycle.ViewModel
import com.cis.baseapp.data.AppDataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val appDataManager: AppDataManager) : ViewModel()  {
}