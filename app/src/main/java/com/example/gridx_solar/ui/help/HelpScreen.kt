package com.example.gridx_solar.ui.help

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gridx_solar.ui.theme.*

@Composable
fun HelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp)
    ) {

        Text(
            text = "System Assistant",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(16.dp))

        HelpCard(
            question = "Why is efficiency low?",
            answer = "Efficiency drops when load demand is higher than generated solar power or when panels are shaded."
        )

        HelpCard(
            question = "What does a red alert mean?",
            answer = "Red alerts indicate critical issues such as battery deep discharge or core grid failure."
        )

        HelpCard(
            question = "How often should maintenance be done?",
            answer = "Monthly inspections are recommended for connections, batteries, and solar panels."
        )

        HelpCard(
            question = "What happens during cloudy weather?",
            answer = "Solar generation reduces, and the system relies more on stored battery energy."
        )
    }
}

@Composable
fun HelpCard(question: String, answer: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(question, color = GreenPrimary)
            Spacer(Modifier.height(4.dp))
            Text(answer, color = TextSecondary)
        }
    }
}
