package com.hackillinois.snapchatUIComposeClone.common.utils

/**
 * Screens
 *
 * @property route
 * @constructor Create empty Screens
 */
sealed class Screens(val route: String) {
    object CameraScreen : Screens("camera")
    object ChatScreen : Screens("chat")
    object MemoriesScreen : Screens("memories")
    object SnapMapScreen : Screens("snapMap")
}
