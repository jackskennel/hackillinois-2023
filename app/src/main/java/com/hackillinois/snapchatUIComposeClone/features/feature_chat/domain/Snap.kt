package com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain

import android.media.Image
import com.hackillinois.snapchatUIComposeClone.common.domain.model.SnapDurationType

/**
 * Snap Data Class
 *
 * @property contentType
 * @property image
 * @property durationType
 * @constructor Create empty Snap
 */
data class Snap(
    val contentType: ContentType,
    val image: Image,
    val durationType: SnapDurationType
)
