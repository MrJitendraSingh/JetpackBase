package com.cis.baseapp.ui.auth

import androidx.lifecycle.ViewModel
import com.cis.baseapp.data.AppDataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(val appDataManager: AppDataManager) : ViewModel() {

//    val response : MutableState<List<Todo>> = mutableStateOf(listOf())
//    suspend fun insertData(title:MutableState<String>, description:MutableState<String>){
//        viewModelScope.launch {
//            appDataManager.insertData(todo = Todo(title = title.value, description = description.value))
//        }
//    }
//
//    init {
//        getData()
//    }

//    private fun getData()= viewModelScope.launch {
//        appDataManager.getData().catch {
//        Log.e("Error", it.message.toString())
//    }.collect{
//        response.value = it
//    }
//    }
}