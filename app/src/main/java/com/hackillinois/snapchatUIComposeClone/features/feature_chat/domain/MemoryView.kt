package com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain

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
    val image: Int,
    val memoryName: String,
    val datePosted: Date,
    val dateUnlocked: Date,
    val isUnlocked: Boolean,
    val numViews: Int
)