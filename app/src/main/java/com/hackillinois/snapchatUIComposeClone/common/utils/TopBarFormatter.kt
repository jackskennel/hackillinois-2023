package com.hackillinois.snapchatUIComposeClone.common.utils

import com.hackillinois.snapchatUIComposeClone.common.config.topBarConfig
import com.hackillinois.snapchatUIComposeClone.common.domain.model.TopBarItem

/**
 * Top bar formatter and route controller
 *
 * @param route
 * @return
 */
fun topBarFormatter(route: String?): TopBarItem {
    return when (route) {
        Screens.SnapMapScreen.route -> {
            topBarConfig(Screens.SnapMapScreen.route)
        }
        Screens.ChatScreen.route -> {
            topBarConfig(Screens.ChatScreen.route)
        }
        Screens.CameraScreen.route -> {
            topBarConfig(Screens.CameraScreen.route)
        }
        else -> {
            topBarConfig(Screens.CameraScreen.route)
        }
    }
}
