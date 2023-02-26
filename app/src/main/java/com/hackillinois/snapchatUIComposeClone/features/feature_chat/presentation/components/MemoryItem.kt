package com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.components.AutoSizeText
import com.hackillinois.snapchatUIComposeClone.common.utils.ThemeColors
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.MemoryView
import java.util.Date

@Preview
@Composable
fun MemoryItemPreview() {
    MemoryItem(
        modifier = Modifier
            .background(color = Color.White)
            .padding(10.dp),
        item = MemoryView(
            ownerId = "",
            image = R.drawable.logo_opaque,
            memoryName = "My memory",
            datePosted = Date(),
            dateUnlocked = Date(),
            isUnlocked = false,
            numViews = 10
        )
    )
}

/**
 * Memory item
 *
 * @param modifier
 * @param item
 */
@Composable
fun MemoryItem(
    modifier: Modifier = Modifier,
    item: MemoryView
) {
    val configuration = LocalConfiguration.current
    Card (
        elevation = CardDefaults.cardElevation()
    ) {
        Image (
            painter = painterResource(id = R.drawable.logo_opaque),
            contentDescription = ""
        )
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AutoSizeText(
                factor = 1f,
                text = item.memoryName,
                textColor = ThemeColors.DARK_TINT_TEXT,
                fontWeight = FontWeight.W600,
                textStyle = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center,
                configuration = configuration
            )
            Row(
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(color = ThemeColors.LIGHT_TINT_TEXT)
                )
                Spacer(Modifier.width(10.dp))
                AutoSizeText(
                    factor = 0.85f,
                    text = "Posted on ${item.datePosted}",
                    textColor = ThemeColors.LIGHT_TINT_TEXT,
                    textStyle = TextStyle(fontSize = 14.sp),
                    configuration = configuration
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(color = ThemeColors.LIGHT_TINT_TEXT)
                )
                Spacer(Modifier.width(10.dp))
                AutoSizeText(
                    factor = 0.85f,
                    text = "Unlocks ${item.datePosted}",
                    textColor = ThemeColors.LIGHT_TINT_TEXT,
                    textStyle = TextStyle(fontSize = 14.sp),
                    configuration = configuration
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (item.isUnlocked) {
                AutoSizeText(
                    factor = 0.85f,
                    text = "${item.numViews} views",
                    textColor = ThemeColors.LIGHT_TINT_TEXT,
                    textStyle = TextStyle(fontSize = 14.sp),
                    configuration = configuration
                )
            }
        }
    }
    Divider(color = Color(0xFFE4E4E4), thickness = 0.1.dp)
}
