package com.cis.baseapp.ui.auth.nav

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cis.baseapp.ui.auth.AuthViewModel
import com.cis.baseapp.ui.auth.splash.SplashScreen
import com.cis.baseapp.ui.main.MainActivity

@Composable
fun AuthNavHost(context: Activity){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AuthNavScreens.SplashScreen.route){
        composable(AuthNavScreens.SplashScreen.route){ SplashScreen(navController) }
        composable(AuthNavScreens.MainActivity.route){
            context.startActivity(Intent(context, MainActivity::class.java))
            context.finish()
        }
    }
}