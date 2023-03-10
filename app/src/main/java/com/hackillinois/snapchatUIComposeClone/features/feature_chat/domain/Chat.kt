package com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain

import android.media.Image
import com.hackillinois.snapchatUIComposeClone.common.domain.model.User

/**
 * Chat Data Class
 *
 * @property sender
 * @property textData
 * @property image
 * @property timeStamp
 * @constructor Create empty Chat
 */
data class Chat(
    val sender: User,
    val textData: Boolean,
    val image: Image,
    val timeStamp: Long,
)
