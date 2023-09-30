package com.cis.baseapp.ui.main.add

import androidx.lifecycle.ViewModel
import com.cis.baseapp.data.AppDataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddPersonViewModel @Inject constructor(val appDataManager: AppDataManager) : ViewModel()  {
}