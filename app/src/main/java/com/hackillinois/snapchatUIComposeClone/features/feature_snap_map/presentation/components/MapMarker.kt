package com.hackillinois.snapchatUIComposeClone.features.feature_snap_map.presentation.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.*
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberMarkerState
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.models.Memory



@SuppressLint("RememberReturnType")
@Composable
fun MapMarker(
    context: Context,
    memory: Memory
) {



    val markerPosition = LatLng(memory.latitude, memory.longitude)


    MarkerInfoWindow(
        state = MarkerState(position = markerPosition),
        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE),
    ) { marker ->
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp),

                )
            ,
        )
        {
            val bmp = BitmapFactory.decodeByteArray(memory.content, 0, memory.content.size)
            Image(
                bitmap = bmp.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp))
                )

        }


    }






}