package com.example.gridx_solar.ui.efficiency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gridx_solar.ui.theme.*

@Composable
fun EfficiencyScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp)
    ) {

        // 🔹 HEADER
        Text(
            text = "System Efficiency",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(20.dp))

        // 🔹 BIG EFFICIENCY CARD (MAIN FOCUS)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardWhite),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Overall Efficiency",
                    color = TextSecondary
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "12%",
                    color = GreenPrimary,
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Low Efficiency Detected",
                    color = AlertWarning
                )

                Spacer(Modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = 0.12f,
                    color = GreenPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        // 🔹 PERFORMANCE BREAKDOWN
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardWhite),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(Modifier.padding(16.dp)) {

                Text(
                    text = "Performance Breakdown",
                    color = GreenPrimary,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(12.dp))

                MetricRow("Generated Energy", "18 kWh", true)
                MetricRow("Consumed Energy", "15.8 kWh", true)
                MetricRow("System Losses", "2.2 kWh", false)
            }
        }

        Spacer(Modifier.height(20.dp))

        // 🔹 AI-LIKE INSIGHT (THIS MAKES IT FEEL SMART)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardWhite),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(Modifier.padding(16.dp)) {

                Text(
                    text = "System Insight",
                    color = OrangePrimary,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Efficiency is reduced due to partial panel shading and high evening load demand. Battery discharge cycles are also increasing losses.",
                    color = TextSecondary
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // 🔹 ACTIONABLE IMPROVEMENTS (VERY IMPORTANT)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardWhite),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(Modifier.padding(16.dp)) {

                Text(
                    text = "Recommended Actions",
                    color = GreenPrimary,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(8.dp))

                Text("• Clean solar panels to remove shading")
                Text("• Shift non-critical loads to daytime")
                Text("• Schedule battery health inspection")
                Text("• Balance village-level consumption")
            }
        }
    }
}

@Composable
fun MetricRow(label: String, value: String, positive: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Text(
            value,
            color = if (positive) GreenPrimary else AlertCritical,
            fontWeight = FontWeight.SemiBold
        )
    }
}
