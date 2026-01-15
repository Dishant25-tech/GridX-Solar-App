package com.example.gridx_solar.ui.`login`



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLogin: () -> Unit = {}) {

    var selectedUser by remember { mutableStateOf("Government") }
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(48.dp))

        // 🔹 LOGO PLACEHOLDER
        Text(
            text = "GRIDX",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(32.dp))

        // 🔹 USER TYPE CARD
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0)),
            shape = RoundedCornerShape(6.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = "Select User Type",
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedUser == "Government",
                        onClick = { selectedUser = "Government" }
                    )
                    Text("Government")

                    Spacer(Modifier.width(16.dp))

                    RadioButton(
                        selected = selectedUser == "Private",
                        onClick = { selectedUser = "Private" }
                    )
                    Text("Private Operator")
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // 🔹 USER ID FIELD
        OutlinedTextField(
            value = userId,
            onValueChange = { userId = it },
            placeholder = { Text("user_id") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFE0E0E0),
                focusedContainerColor = Color(0xFFE0E0E0),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(4.dp)
        )

        Spacer(Modifier.height(12.dp))

        // 🔹 PASSWORD FIELD
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("password") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFE0E0E0),
                focusedContainerColor = Color(0xFFE0E0E0),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(4.dp)
        )

        Spacer(Modifier.height(24.dp))

        // 🔹 LOGIN BUTTON
        Button(
            onClick = onLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A5ACD)
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}
