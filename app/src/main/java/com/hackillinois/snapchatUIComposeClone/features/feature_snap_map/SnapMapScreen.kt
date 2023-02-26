package com.hackillinois.snapchatUIComposeClone.features.feature_snap_map


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import com.hackillinois.snapchatUIComposeClone.common.utils.RealmProvider
import com.hackillinois.snapchatUIComposeClone.common.utils.ThemeColors
import com.hackillinois.snapchatUIComposeClone.features.feature_snap_map.presentation.components.MapBottomNavigation
import com.hackillinois.snapchatUIComposeClone.features.feature_snap_map.presentation.components.MapMarker


@Composable
@Preview
fun SnapMapScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
        ) {
            val context = LocalContext.current
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                uiSettings = MapUiSettings(zoomControlsEnabled = false),
                properties = MapProperties(
                    mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.style_json)
                ),
                cameraPositionState = CameraPositionState(
                    CameraPosition(
                        LatLng(40.11395268359537, -88.22499888074972), 12f, 0f, 0f
                    )
                )
            ){
                // make request to db
                val realm = RealmProvider().getRealm()
                val memories = realm.query(Memory::class).find()

                Log.d("SnapMapScreen", "memories: ${memories.toString()}")

                memories.forEach { memory: Memory ->
                    Log.d("SnapMapScreen", "memory: ${memory.toString()}")
                    val markerPosition = LatLng(memory.latitude, memory.longitude)

                    MapMarker(
                        context = LocalContext.current,
                        memory = memory
                    )
                }
            }
            Box(
                modifier = Modifier
                    .rotate(180f)
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                ThemeColors.MAP_DARK_GRADIENT
                            ),
                            startY = 10f
                        ),
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0x6F202020)
                            ),
                        ),
                    ),
                contentAlignment = Alignment.BottomCenter,
            ) {
                MapBottomNavigation()
            }
        }
    }
}
