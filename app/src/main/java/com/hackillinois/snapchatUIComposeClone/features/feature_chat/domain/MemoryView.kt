package com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain

import android.graphics.Bitmap
import java.util.Date

/**
 * Memory view data class
 *
 * @property image
 * @property memoryName
 * @property datePosted
 * @property dateUnlocked
 * @property isUnlocked
 * @property numViews
 */
data class MemoryView (
    val ownerId: String,
    val bitmap: Bitmap,
    val memoryName: String,
    val datePosted: Date,
    val dateUnlocked: Date,
    val isUnlocked: Boolean,
    val numViews: Int
)