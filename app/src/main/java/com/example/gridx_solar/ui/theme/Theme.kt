package com.example.gridx_solar.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val GridXColorScheme = lightColorScheme(
    primary = GreenPrimary,
    secondary = OrangePrimary,
    background = BackgroundLight,
    surface = CardWhite,
    onPrimary = Color.White,
    onSurface = TextPrimary
)

@Composable
fun GridXSolarTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = GridXColorScheme,
        typography = Typography(),
        content = content
    )
}
