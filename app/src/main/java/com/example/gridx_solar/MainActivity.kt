package com.example.gridx_solar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.gridx_solar.ui.alerts.AlertsScreen
import com.example.gridx_solar.ui.dashboard.DashboardScreen
import com.example.gridx_solar.ui.help.HelpScreen
import com.example.gridx_solar.ui.login.LoginScreen
import com.example.gridx_solar.ui.reports.ReportsScreen
import com.example.gridx_solar.ui.navigation.BottomNavBar
import com.example.gridx_solar.ui.theme.GridXSolarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridXSolarTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var isLoggedIn by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    if (!isLoggedIn) {
        LoginScreen(onLogin = { isLoggedIn = true })
    } else {
        Scaffold(
            bottomBar = {
                BottomNavBar(
                    selectedIndex = selectedIndex,
                    onItemSelected = { selectedIndex = it }
                )
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when (selectedIndex) {
                    0 -> DashboardScreen()
                    1 -> AlertsScreen()
                    2 -> ReportsScreen()
                    3 -> HelpScreen()
                }
            }
        }
    }
}
