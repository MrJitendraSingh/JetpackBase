package com.cis.baseapp.ui.main.nav


sealed class MainNavScreens(val route:String){
    object HomeScreen : MainNavScreens("HomeScreen")
    object AddPersonScreen : MainNavScreens("AddPersonScreen")
    object SearchScreen : MainNavScreens("SearchScreen")
}
