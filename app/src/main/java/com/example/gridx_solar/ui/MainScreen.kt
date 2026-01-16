package com.example.gridx_solar.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridx_solar.ui.alerts.AlertsScreen
import com.example.gridx_solar.ui.dashboard.DashboardScreen
import com.example.gridx_solar.ui.efficiency.EfficiencyScreen
import com.example.gridx_solar.ui.help.HelpScreen
import com.example.gridx_solar.ui.navigation.BottomNavBar

@Composable
fun MainScreen(onLogout: () -> Unit) {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    val route = when (index) {
                        0 -> "dashboard"
                        1 -> "alerts"
                        2 -> "efficiency"
                        else -> "help"
                    }
                    navController.navigate(route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("dashboard") { DashboardScreen(onLogout = onLogout) }
            composable("alerts") { AlertsScreen() }
            composable("efficiency") { EfficiencyScreen() }
            composable("help") { HelpScreen() }
        }
    }
}
