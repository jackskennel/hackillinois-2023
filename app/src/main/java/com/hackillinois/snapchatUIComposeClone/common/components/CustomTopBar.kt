package com.hackillinois.snapchatUIComposeClone.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.domain.model.TopBarItem

/**
 * Custom top bar
 *
 * @param modifier
 * @param topBarItem
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    topBarItem: TopBarItem
) {
    val configuration = LocalConfiguration.current

    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = if (topBarItem.isBackgroundTransparent)
                Color.Transparent
            else
                Color.White,
        ),
        title = {
            Text(
                text = topBarItem.name,
                modifier = Modifier
                    .padding(top = 5.dp),
                color = topBarItem.textColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        },
        actions = {
            if (topBarItem.isAvailable) {
                CustomActionBar(topBarItem, configuration)
            }
        },
        navigationIcon = {
        }
    )
}
//    TopAppBar(
//        contentPadding = PaddingValues(top = 10.dp, start = 10.dp, end = 10.dp),
//        modifier = modifier,
//        elevation = 0.dp,
//        backgroundColor =
//        if (topBarItem.isBackgroundTransparent)
//            Color.Transparent
//        else
//            Color.White,
//        content = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .align(Alignment.CenterVertically),
//            ) {
//
//
//                Box(
//                    Modifier.align(Alignment.TopEnd)
//                ) {
//
//                }
//            }
//        }
//    )
