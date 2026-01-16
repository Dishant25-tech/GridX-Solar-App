package com.example.gridx_solar.ui.alerts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gridx_solar.ui.theme.*

@Composable
fun AlertsScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(16.dp)) {

        AlertCard(
            title = "Cloudy Weather Today",
            message = "Reduced solar generation expected",
            severity = "Info"
        )

        AlertCard(
            title = "Poor Load Management",
            message = "Core loss detected due to load imbalance",
            severity = "Warning"
        )

        AlertCard(
            title = "Shading on Panel Detected",
            message = "Output reduced by 18%",
            severity = "Warning"
        )

        AlertCard(
            title = "Battery Deep Discharge",
            message = "Maintenance required this month",
            severity = "Critical"
        )
    }
}

@Composable
fun AlertCard(
    title: String,
    message: String,
    severity: String
) {
    val color = when (severity) {
        "Info" -> AlertInfo
        "Warning" -> AlertWarning
        else -> AlertCritical
    }

    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, color = color, style = MaterialTheme.typography.titleMedium)
            Text(message, color = TextSecondary, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(severity, color = color, style = MaterialTheme.typography.labelMedium)
        }
    }
}
