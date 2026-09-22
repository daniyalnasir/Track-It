package com.codeshod.design_systems.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme


val LightColorScheme = lightColorScheme(
    primary = primaryLight,
    primaryContainer = primaryContainerLight,
    secondary = secondaryLight,
    tertiary = tertiaryLight
)

val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    primaryContainer = primaryContainerDark,
    secondary = secondaryDark,
    tertiary = tertiaryDark
)

/* Other default colors to override
background = Color(0xFFFFFBFE),
surface = Color(0xFFFFFBFE),
onPrimary = Color.White,
onSecondary = Color.White,
onTertiary = Color.White,
onBackground = Color(0xFF1C1B1F),
onSurface = Color(0xFF1C1B1F),
*/