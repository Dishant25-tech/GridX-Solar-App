package com.example.gridx_solar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridx_solar.ui.MainScreen
import com.example.gridx_solar.ui.login.LoginScreen
import com.example.gridx_solar.ui.signup.SignupScreen
import com.example.gridx_solar.ui.theme.GridXSolarTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridXSolarTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val auth = FirebaseAuth.getInstance()

    val startDestination = if (auth.currentUser != null) {
        "main"
    } else {
        "login"
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onGoToSignup = {
                    navController.navigate("signup")
                }
            )
        }
        composable("signup") {
            SignupScreen(
                onSignup = {
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onGoToLogin = {
                    navController.navigateUp()
                }
            )
        }
        composable("main") {
            MainScreen(onLogout = {
                auth.signOut()
                navController.navigate("login") {
                    popUpTo("main") { inclusive = true }
                }
            })
        }
    }
}