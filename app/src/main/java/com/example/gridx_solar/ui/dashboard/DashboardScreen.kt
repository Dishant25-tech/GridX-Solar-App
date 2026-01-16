package com.example.gridx_solar.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gridx_solar.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun DashboardScreen(onLogout: () -> Unit) {
    val auth = FirebaseAuth.getInstance()
    val db = Firebase.firestore
    var userName by remember { mutableStateOf("User") }

    LaunchedEffect(key1 = auth.currentUser) {
        val uid = auth.currentUser?.uid
        if (uid != null) {
            db.collection("users").document(uid).get()
                .addOnSuccessListener { doc ->
                    userName = doc.getString("name") ?: "User"
                }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Welcome, $userName 👋",
                style = MaterialTheme.typography.titleLarge
            )
            TextButton(onClick = onLogout) {
                Text("Logout")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
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
