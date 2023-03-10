package com.hackillinois.snapchatUIComposeClone.common.config

import androidx.compose.ui.graphics.Color
import com.hackillinois.snapchatUIComposeClone.common.domain.model.TopBarItem
import com.hackillinois.snapchatUIComposeClone.common.utils.Messages
import com.hackillinois.snapchatUIComposeClone.common.utils.Screens
import com.hackillinois.snapchatUIComposeClone.common.utils.ThemeColors

/**
 * Top bar config
 *
 * @param route
 * @return
 */
fun topBarConfig(route: String): TopBarItem {
    val listOfTopBarConfig = listOf(
        TopBarItem(
            name = Messages.SNAP_HEADING,
            textColor = ThemeColors.LIGHT_ICON_TINT,
            backgroundTintForIcon = ThemeColors.DARK_TRANSPARENT,
            iconTint = ThemeColors.LIGHT_ICON_TINT,
            route = Screens.SnapMapScreen.route,
            isBackgroundTransparent = true,
            isAvailable = true,
            lastAction = "Setting"
        ),
        TopBarItem(
            name = Messages.CHAT_HEADING,
            textColor = Color.Black,
            backgroundTintForIcon = ThemeColors.LIGHT_TRANSPARENT,
            iconTint = ThemeColors.DARK_ICON_TINT,
            route = Screens.ChatScreen.route,
            isAvailable = true,
            lastAction = "More Action"
        ),
        TopBarItem(
            name = "",
            textColor = ThemeColors.LIGHT_ICON_TINT,
            backgroundTintForIcon = ThemeColors.DARK_TRANSPARENT,
            iconTint = ThemeColors.LIGHT_ICON_TINT,
            route = Screens.CameraScreen.route,
            isBackgroundTransparent = true,
            isAvailable = false,
            lastAction = "Camera Rotate"
        )
    )
    return listOfTopBarConfig.find { it.route == route }!!
}
