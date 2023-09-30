package com.cis.baseapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.cis.baseapp.ui.auth.AuthViewModel
import com.cis.baseapp.ui.main.nav.MainNavHost
import com.cis.baseapp.ui.theme.BaseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private fun getViewModel() : AuthViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.Blue.toArgb()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column {
                    topAppBar()
                    MainNavHost(this@MainActivity)
                }
            }
        }
    }
}


@Composable
fun topAppBar(){
//    Scaffold(
//        modifier = Modifier.fillMaxWidth(),
//        topBar = {
//            TopAppBar(title = { Text(text = "Android App", color = Color.White)},
//            actions = {
//                IconButton(onClick = { }) {
//                    Icon(Icons.Filled.Search, contentDescription = "search", tint = Color.White)
//                }
//                IconButton(onClick = { }) {
//                    Icon(Icons.Filled.Add, contentDescription = "add", tint = Color.White)
//                }
//            })
//        }
//    ) {
//    }

    Row(modifier = Modifier.fillMaxWidth().background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Android App", color = Color.White)
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Search, contentDescription = "search", tint = Color.White)
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Add, contentDescription = "add", tint = Color.White)
        }
    }
}