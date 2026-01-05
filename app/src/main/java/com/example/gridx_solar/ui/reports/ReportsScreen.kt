package com.example.gridx_solar.ui.reports

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gridx_solar.ui.theme.*

@Composable
fun ReportsScreen() {

    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Daily", "Monthly", "Yearly")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp)
    ) {

        // 🔹 HEADER
        Text(
            text = "Energy Reports",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Daily | Monthly | Yearly",
            color = TextSecondary
        )

        Spacer(Modifier.height(20.dp))

        // 🔹 TABS
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // 🔹 SUMMARY CARDS
        ReportCard(
            title = "Energy Generated",
            value = when (selectedTab) {
                0 -> "18 kWh"
                1 -> "540 kWh"
                else -> "6,480 kWh"
            },
            color = GreenPrimary
        )

        ReportCard(
            title = "Energy Consumed",
            value = when (selectedTab) {
                0 -> "15.8 kWh"
                1 -> "470 kWh"
                else -> "5,640 kWh"
            },
            color = OrangePrimary
        )

        ReportCard(
            title = "System Loss",
            value = when (selectedTab) {
                0 -> "2.2 kWh"
                1 -> "70 kWh"
                else -> "840 kWh"
            },
            color = AlertCritical
        )

        Spacer(Modifier.height(24.dp))

        // 🔹 VISUAL COMPARISON
        Text(
            text = "Energy Comparison",
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = 0.78f,
            color = GreenPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Spacer(Modifier.height(6.dp))

        LinearProgressIndicator(
            progress = 0.68f,
            color = OrangePrimary,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Spacer(Modifier.height(24.dp))

        // 🔹 INSIGHT
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardWhite),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = "Report Insight",
                    color = GreenPrimary,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Energy losses are within acceptable limits. Improving load scheduling during peak hours can further enhance efficiency.",
                    color = TextSecondary
                )
            }
        }
    }
}

@Composable
fun ReportCard(
    title: String,
    value: String,
    color: androidx.compose.ui.graphics.Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, color = TextSecondary)
            Text(value, color = color, fontWeight = FontWeight.Bold)
        }
    }
}
