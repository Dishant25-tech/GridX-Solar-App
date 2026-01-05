package com.example.gridx_solar.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.gridx_solar.ui.theme.GreenPrimary
import com.example.gridx_solar.ui.theme.TextSecondary

@Composable
fun BottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Dashboard") },
            label = { Text("Dashboard") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                unselectedIconColor = TextSecondary
            )
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) },
            icon = { Icon(Icons.Filled.Warning, contentDescription = "Alerts") },
            label = { Text("Alerts") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                unselectedIconColor = TextSecondary
            )
        )

        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) },
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Efficiency") },
            label = { Text("Efficiency") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                unselectedIconColor = TextSecondary
            )
        )

        NavigationBarItem(
            selected = selectedIndex == 3,
            onClick = { onItemSelected(3) },
            icon = { Icon(Icons.Filled.Info, contentDescription = "Help") },
            label = { Text("Help") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                unselectedIconColor = TextSecondary
            )
        )
    }
}
