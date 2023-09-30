package com.cis.baseapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.lifecycle.ViewModelProvider
import com.cis.baseapp.ui.auth.nav.AuthNavHost
import com.cis.baseapp.ui.auth.nav.AuthNavScreens
import com.cis.baseapp.ui.main.MainActivity
import com.cis.baseapp.ui.theme.BaseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    private fun getViewModel() : AuthViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseAppTheme {
                Surface {
                    Column {
                        AuthNavHost(context = this@AuthActivity)
                        Handler().postDelayed({
                                              startActivity(Intent(this@AuthActivity, MainActivity::class.java))
                        }, 3000)
                    }
                }
            }
        }
    }
}
