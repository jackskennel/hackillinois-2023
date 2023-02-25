package com.hackillinois.snapchatUIComposeClone.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColorScheme(
    primary = Red80,
    onPrimary = Color.White,
    primaryContainer = Red200,
    onPrimaryContainer = Red900,
    inversePrimary = Red200,
    secondary = Pink100,
    onSecondary = Color.White,
    secondaryContainer = Red90,
    onSecondaryContainer = Red10,
    tertiary = Pink400,
    onTertiary = Color.White,
    tertiaryContainer = Pink50,
    onTertiaryContainer = Pink700,
    error = Red40,
    onError = Color.White,
    errorContainer = Red50,
    onErrorContainer = Red900,
    background = Grey99,
    onBackground = Grey10,
    surface = IconColor,
    onSurface = Grey99,
    inverseSurface = Grey10,
    inverseOnSurface = Grey95,
    surfaceVariant = Pink200,
    onSurfaceVariant = Grey99,
    outline = Red500
)

/**
 * Compose snap chat ui theme
 *
 * @param content
 * @receiver
 */
@Composable
fun ComposeSnapChatUITheme(
    content: @Composable() () -> Unit
) {
    val colors = LightColorPalette
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        // shapes = Shapes,
        content = content
    )
}
