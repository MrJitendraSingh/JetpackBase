package com.cis.baseapp.ui.auth.nav


sealed class AuthNavScreens(val route:String){
    object SplashScreen : AuthNavScreens("SplashScreen")
    object MainActivity : AuthNavScreens("MainActivity")
}
