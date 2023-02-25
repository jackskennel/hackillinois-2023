package com.hackillinois.snapchatUIComposeClone.common.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PlayArrow
import com.hackillinois.snapchatUIComposeClone.common.domain.model.BottomNavItem
import com.hackillinois.snapchatUIComposeClone.common.utils.Messages
import com.hackillinois.snapchatUIComposeClone.common.utils.Screens
import com.hackillinois.snapchatUIComposeClone.common.utils.ThemeColors

/**
 * Navigation config
 *
 * @return
 */
fun navigationConfig(): List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            name = Messages.SNAP_HEADING,
            route = Screens.SnapMapScreen.route,
            icon = Icons.Outlined.LocationOn,
            onSelectedBatchVisible = false,
            onSelectedColor = ThemeColors.GREEN,
            onSelectIcon = Icons.Outlined.LocationOn,
        ),
        BottomNavItem(
            name = Messages.CHAT_HEADING,
            route = Screens.ChatScreen.route,
            icon = Icons.Default.ChatBubbleOutline,
            onSelectedBatchVisible = true,
            onSelectedColor = ThemeColors.BLUE,
            onSelectIcon = Icons.Default.ChatBubbleOutline,
        ),
        BottomNavItem(
            name = Messages.CAMERA_HEADING,
            route = Screens.CameraScreen.route,
            icon = Icons.Outlined.CameraAlt,
            onSelectedBatchVisible = false,
            onSelectedColor = ThemeColors.YELLOW,
            onSelectIcon = Icons.Default.CameraAlt,
        ),
        BottomNavItem(
            name = Messages.STORIES_HEADING,
            route = Screens.StoriesScreen.route,
            icon = Icons.Outlined.Group,
            onSelectedBatchVisible = true,
            onSelectedColor = ThemeColors.PURPLE,
            onSelectIcon = Icons.Outlined.Group,
        ),
        BottomNavItem(
            name = Messages.SPOTLIGHT_HEADING,
            route = Screens.SpotlightScreen.route,
            icon = Icons.Outlined.PlayArrow,
            onSelectedBatchVisible = false,
            onSelectedColor = ThemeColors.RED,
            onSelectIcon = Icons.Outlined.PlayArrow,
        )
    )
}
