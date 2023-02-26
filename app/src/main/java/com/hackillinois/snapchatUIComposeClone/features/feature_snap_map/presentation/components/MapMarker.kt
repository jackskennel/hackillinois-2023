package com.hackillinois.snapchatUIComposeClone.features.feature_snap_map.presentation.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import com.hackillinois.snapchatUIComposeClone.common.models.Memory

fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
    return ContextCompat.getDrawable(context, vectorResId)?.run {
        setBounds(0, 0, intrinsicWidth, intrinsicHeight)
        val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
        draw(Canvas(bitmap))
        BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}

@Composable
fun MapMarker(
    context: Context,
    memory: Memory
) {

    val markerPosition = LatLng(memory.latitude, memory.longitude)
    Marker(
        state = rememberMarkerState(position = markerPosition),
        title = memory.name.ifEmpty { "Memory" },
        snippet = "Unlocks at ${memory.unlockedAt}",
        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE),
        onClick = {
            Log.d("MapMarker", "Clicked on marker")
            return@Marker true
        }
    )


}