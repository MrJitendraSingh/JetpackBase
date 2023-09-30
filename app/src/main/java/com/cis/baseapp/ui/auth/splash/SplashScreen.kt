package com.cis.baseapp.ui.auth.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.cis.baseapp.R
import com.cis.baseapp.ui.auth.nav.AuthNavScreens

@Composable
fun SplashScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()) {
//        Image(painterResource(R.drawable.splash_screen),
//            contentDescription = "",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.FillWidth)
//        Image(painterResource(R.drawable.ic_logo),
//            contentDescription = "",
//            modifier = Modifier.align(alignment = Alignment.Center))
//        Handler().postDelayed({
//            navController.navigate(AuthNavScreens.MainActivity.route)
//        }, 3000)
    }
}