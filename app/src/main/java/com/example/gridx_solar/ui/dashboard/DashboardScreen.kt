package com.example.gridx_solar.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gridx_solar.ui.theme.*

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SectionCard(
            title = "Generation",
            accentColor = GreenPrimary,
            data = listOf(
                "Voltage" to "220 V",
                "Current" to "10 A",
                "Power" to "2.4 kW",
                "Energy Generated" to "18 kWh"
            )
        )

        SectionCard(
            title = "Battery Storage",
            accentColor = OrangePrimary,
            data = listOf(
                "Voltage" to "48 V",
                "Current" to "8 A",
                "Power" to "1.2 kW",
                "Stored Energy" to "12 kWh"
            )
        )

        SectionCard(
            title = "Village 1 Consumption",
            accentColor = AlertInfo,
            data = listOf(
                "Voltage" to "230 V",
                "Current" to "6 A",
                "Power" to "1.4 kW",
                "Energy Used" to "9 kWh"
            )
        )

        SectionCard(
            title = "Village 2 Consumption",
            accentColor = AlertInfo,
            data = listOf(
                "Voltage" to "230 V",
                "Current" to "5 A",
                "Power" to "1.2 kW",
                "Energy Used" to "8 kWh"
            )
        )
    }
}

@Composable
fun SectionCard(
    title: String,
    accentColor: Color,
    data: List<Pair<String, String>>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = title,
                color = accentColor,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(8.dp))
            data.forEach { (label, value) ->
                Text(
                    text = "$label: $value",
                    color = TextSecondary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
