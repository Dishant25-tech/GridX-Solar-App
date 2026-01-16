package com.example.gridx_solar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridx_solar.ui.dashboard.DashboardScreen
import com.example.gridx_solar.ui.alerts.AlertsScreen
import com.example.gridx_solar.ui.efficiency.EfficiencyScreen
import com.example.gridx_solar.ui.help.HelpScreen
import com.example.gridx_solar.ui.login.LoginScreen
import com.example.gridx_solar.ui.signup.SignupScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val auth = FirebaseAuth.getInstance()

    val startDestination = if (auth.currentUser != null) {
        "dashboard"
    } else {
        "login"
    }

    NavHost(navController = navController, startDestination = startDestination) {

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("dashboard") {
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
                    navController.navigate("dashboard") {
                        popUpTo("signup") { inclusive = true }
                    }
                },
                onGoToLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("dashboard") {
            DashboardScreen(onLogout = {
                auth.signOut()
                navController.navigate("login") {
                    popUpTo("dashboard") { inclusive = true }
                }
            })
        }

        composable("alerts") { AlertsScreen() }
        composable("efficiency") { EfficiencyScreen() }
        composable("help") { HelpScreen() }
    }
}
