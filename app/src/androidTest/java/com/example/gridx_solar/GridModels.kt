

package com.example.gridx_solar

import androidx.compose.ui.graphics.Color

enum class Severity { INFO, WARNING, CRITICAL }

data class Alert(
    val title: String,
    val msg: String,
    val severity: Severity,
    val time: String,
    val color: Color
)