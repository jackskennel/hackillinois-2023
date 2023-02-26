package com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components

import android.net.Uri
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.MemoryView


/**
 * Video player
 *
 * @param uri
 */
@Composable
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun ImagePlayer(memoryView: MemoryView) {
    val context = LocalContext.current
    // make an image that is full-screen using R.drawable.blanc

    Image (
        bitmap = memoryView.bitmap.asImageBitmap(),
        contentDescription = "pls work",
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    )
//
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context)
//            .build()
//            .apply {
//                // set static image as media source
//                val dataSource: DataSource.Factory = DefaultDataSource.Factory(context)
//                val source = ImageMediaSource()
//
//                setMediaSource(source)
//                prepare()
//            }
//    }
//
//    exoPlayer.playWhenReady = true
//    exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
//    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
//
//    DisposableEffect(
//        AndroidView(factory = {
//            PlayerView(context).apply {
//                hideController()
//                useController = false
//                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
//
//                player = exoPlayer
//                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
//            }
//        })
//    ) {
//        onDispose { exoPlayer.release() }
//    }
}
