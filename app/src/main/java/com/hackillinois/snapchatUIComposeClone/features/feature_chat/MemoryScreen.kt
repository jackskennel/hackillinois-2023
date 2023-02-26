package com.hackillinois.snapchatUIComposeClone.features.feature_chat

import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import com.hackillinois.snapchatUIComposeClone.common.utils.RealmProvider
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.domain.MemoryView
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components.ImagePlayer
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components.MemoryItem
import com.hackillinois.snapchatUIComposeClone.features.feature_chat.presentation.components.SpotlightFooter
import java.time.Instant
import java.util.*

/**
 * Chat screen
 *
 */
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//@Preview
//fun ChatScreen() {
//    val realm = RealmProvider().getRealm()
//    val memories = realm.query(Memory::class).find().toList()
//
//    val memoryViews = memories.filter { memory -> memory.content.isNotEmpty()} .map { memory ->
//        val bitmap = BitmapFactory.decodeByteArray(memory.content, 0, memory.content.size)
//
//        MemoryView(
//            ownerId = memory.owner_id.toString(),
//            bitmap = bitmap,
//            memoryName = memory.name,
//            datePosted = Date.from(Instant.ofEpochSecond(memory.uploadedAt)),
//            dateUnlocked = Date.from(Instant.ofEpochSecond(memory.unlockedAt)),
//            isUnlocked = Date.from(Instant.ofEpochSecond(memory.unlockedAt)).before(Date.from(Instant.now())),
//            numViews = 0
//        )
//    }
//
//    Box(
//        modifier = Modifier
//            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
//            .background(color = Color.White)
//            .fillMaxSize(),
//    ) {
//        LazyColumn {
//            items(memoryViews.size) { index ->
//                MemoryItem(
//                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
//                    item = memoryViews[index]
//                )
//            }
//        }
//    }
//}

@Composable
fun MemoryScreen() {
    val realm = RealmProvider().getRealm()
    val memories = realm.query(Memory::class).find().toList()

    val memoryViews = memories.filter { memory -> memory.content.isNotEmpty()} .map { memory ->
        val bitmap = BitmapFactory.decodeByteArray(memory.content, 0, memory.content.size)

        MemoryView(
            ownerId = memory.owner_id.toString(),
            bitmap = bitmap,
            memoryName = memory.name,
            datePosted = Date.from(Instant.ofEpochSecond(memory.uploadedAt)),
            dateUnlocked = Date.from(Instant.ofEpochSecond(memory.unlockedAt)),
            isUnlocked = Date.from(Instant.ofEpochSecond(memory.unlockedAt)).before(Date.from(Instant.now())),
            numViews = 0
        )
    }
    Box(
        Modifier
            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
            .background(color = Color.Black)
    ) {
        LazyColumn {
            items(memoryViews.size) { index ->
                Box(
                    modifier = Modifier
                        .fillParentMaxSize()
                ) {
                    ImagePlayer(memoryViews[index])
                    Column(Modifier.align(Alignment.BottomStart)) {
                        SpotlightFooter(memoryViews[index])
                        Divider()
                    }
                }
            }
        }
    }
}