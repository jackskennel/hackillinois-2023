package com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.MemoryView
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.model.Spotlight

@Composable
fun SpotlightFooter(spotlight: MemoryView) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        FooterUserData(
            spotlight = spotlight,
            modifier = Modifier.weight(8f)
        )

        FooterUserAction(
            modifier = Modifier.weight(2f)
        )
    }
}