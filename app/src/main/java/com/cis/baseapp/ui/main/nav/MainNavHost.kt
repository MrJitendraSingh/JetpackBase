package com.cis.baseapp.ui.main.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cis.baseapp.ui.main.add.AddPersonScreen
import com.cis.baseapp.ui.main.home.HomeScreen
import com.cis.baseapp.ui.main.search.SearchScreen

@Composable
fun MainNavHost(context: Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainNavScreens.AddPersonScreen.route){
        composable(MainNavScreens.HomeScreen.route){ HomeScreen() }
        composable(MainNavScreens.AddPersonScreen.route){ AddPersonScreen() }
        composable(MainNavScreens.SearchScreen.route){ SearchScreen() }
    }
}