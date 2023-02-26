package com.hackillinois.snapchatUIComposeClone.common.utils

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.hackillinois.snapchatUIComposeClone.features.feature_camera.CameraScreen
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.MemoryScreen
import com.hackillinois.snapchatUIComposeClone.features.feature_memories.MemoriesScreen
import com.hackillinois.snapchatUIComposeClone.features.feature_snap_map.SnapMapScreen

/**
 * Navigation
 *
 * @param navController
 */
@ExperimentalFoundationApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 5.dp,
                    bottomEnd = 5.dp
                )
            )
            .padding(bottom = 65.dp),
        navController = navController,
        startDestination = Screens.CameraScreen.route
    ) {
        composable(Screens.SnapMapScreen.route) {
            FeaturesThatRequireLocationPermission(
                navigateToSettingsScreen = {},
                content = { SnapMapScreen() }
            )
        }
        composable(Screens.ChatScreen.route) {
            MemoryScreen()
        }
        composable(Screens.CameraScreen.route) {
            FeatureThatRequiresCameraPermission(
                navigateToSettingsScreen = {},
                content = { CameraScreen() }
            )
        }
        composable(Screens.MemoriesScreen.route) {
            MemoriesScreen()
        }
    }
}
