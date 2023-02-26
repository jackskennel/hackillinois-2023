package com.hackillinois.snapchatUIComposeClone.features.feature_chat.data.dataSource

import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.MemoryView
import java.util.*

fun dummyDataChatViewList(): List<MemoryView> {
    return listOf(
        MemoryView(
            ownerId = "",
            image = R.drawable.logo_opaque,
            memoryName = "Test name",
            datePosted = Date(),
            dateUnlocked = Date(),
            isUnlocked = false,
            numViews = 10
        ),
        MemoryView(
            ownerId = "",
            image = R.drawable.logo_opaque,
            memoryName = "Test name",
            datePosted = Date(),
            dateUnlocked = Date(),
            isUnlocked = false,
            numViews = 10
        ),
        MemoryView(
            ownerId = "",
            image = R.drawable.logo_opaque,
            memoryName = "Test name",
            datePosted = Date(),
            dateUnlocked = Date(),
            isUnlocked = false,
            numViews = 10
        )
    )
}
