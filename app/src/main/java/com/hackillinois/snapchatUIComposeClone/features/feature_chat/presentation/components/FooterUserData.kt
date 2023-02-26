package com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.GraphicEq
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import com.hackillinois.snapchatUIComposeClone.common.utils.ThemeColors
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.MemoryView
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.model.Spotlight


val horizontalPadding = 16.dp
/**
 * Footer user data
 *
 * @param spotlight
 * @param modifier
 */
@Composable
fun FooterUserData(spotlight: MemoryView, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .height(28.dp)
                    .width(28.dp),
                contentAlignment = Alignment.Center
            ) {
                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https://avatars.githubusercontent.com/u/50791485?v=4")
                        .apply(block = fun ImageRequest.Builder.() {
                            transformations(
                                CircleCropTransformation()
                            )
                        }).build()
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "${spotlight.memoryName}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Outlined.BookmarkBorder,
                contentDescription = "Bookmark"
            )
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = Icons.Outlined.Add,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(horizontalPadding))

        // Audio
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = ThemeColors.DARK_TRANSPARENT)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = Icons.Outlined.GraphicEq,
                contentDescription = "Bookmark"
            )

        }
    }
}
