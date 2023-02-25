package com.hackillinois.snapchatUIComposeClone.features.feature_stories.domain.model

import com.hackillinois.snapchatUIComposeClone.common.domain.model.SnapDurationType
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.ContentType

/**
 * Story Data Class
 *
 * @property userId
 * @property timeStamp
 * @property contentType
 * @property mediaURL
 * @property snapDurationType
 * @constructor Create empty Story
 */
data class Story(
    val userId: Long,
    val timeStamp: Long,
    val contentType: ContentType,
    val mediaURL: String,
    val snapDurationType: SnapDurationType
)
