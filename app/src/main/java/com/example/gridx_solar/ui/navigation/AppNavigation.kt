package com.example.gridx_solar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridx_solar.ui.alerts.AlertsScreen
import com.example.gridx_solar.ui.dashboard.DashboardScreen
import com.example.gridx_solar.ui.efficiency.EfficiencyScreen
import com.example.gridx_solar.ui.help.HelpScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen() }
        composable("alerts") { AlertsScreen() }
        composable("efficiency") { EfficiencyScreen() }
        composable("help") { HelpScreen() }
    }
}
