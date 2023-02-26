package com.hackillinois.snapchatUIComposeClone.features.feature_snap_map.presentation.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.*
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.models.Memory



@SuppressLint("RememberReturnType")
@Composable
fun MapMarker(
    context: Context,
    memory: Memory
) {


//    val view = View.inflate(context, R.layout.image_layout, null)

    val markerPosition = LatLng(memory.latitude, memory.longitude)
    Marker(
        state = rememberMarkerState(position = markerPosition),
        title = if(memory.name.isEmpty()) "Memory" else memory.name,
        snippet = "Unlocks at ${memory.unlockedAt}",
//        anchor = Offset(0.5f, 1f),
        icon = BitmapDescriptorFactory.defaultMarker(),
        onClick = {
            Log.d("MapMarker", "Clicked on marker")
            return@Marker true
        }
    )


}