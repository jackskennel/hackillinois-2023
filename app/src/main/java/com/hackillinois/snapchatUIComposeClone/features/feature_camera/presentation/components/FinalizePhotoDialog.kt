package com.hackillinois.snapchatUIComposeClone.features.feature_camera.presentation.components

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.LocationServices
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import com.hackillinois.snapchatUIComposeClone.common.utils.RealmProvider
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("MissingPermission")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinalizePhotoDialog(
    photoBytes: ByteArray
) {
    val context = LocalContext.current
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    Box {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Transparent, RoundedCornerShape(15.dp))
                .padding(8.dp)
                .align(Alignment.BottomCenter)
        ) {
            val memoryName = remember { mutableStateOf(TextFieldValue()) }

            val calendar = Calendar.getInstance()
            val context = LocalContext.current

            var selectedDateText by remember { mutableStateOf("") }

            // Fetching current year, month and day
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

            val hour = calendar[Calendar.HOUR_OF_DAY]
            val minute = calendar[Calendar.MINUTE]

            // Value for storing time as a string
            val time = remember { mutableStateOf("") }

            val timePicker = TimePickerDialog(
                context,
                {_, hour : Int, minute: Int ->
                    time.value = "${(hour).toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}"
                    selectedDateText += time.value
                }, hour, minute, false
            )
            // TODO timePicker has no minimum time. Users can pick a time in the past. Stop that

            val datePicker = DatePickerDialog(
                context,
                { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
                    selectedDateText = "${(selectedMonth + 1).toString().padStart(2, '0')}/${selectedDayOfMonth.toString().padStart(2, '0')}/$selectedYear "
                    timePicker.show()
                }, year, month, dayOfMonth
            )
            datePicker.datePicker.minDate = calendar.timeInMillis

            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = memoryName.value,
                    onValueChange = { memoryName.value = it }
                )
                Button(
                    onClick = { datePicker.show() }
                ) {
                    Text(text = "Select an unlock date")
                }
                Text(
                    text = if (selectedDateText.isNotEmpty()) {
                        "Unlock date: $selectedDateText"
                    } else {
                        ""
                    }
                )
                Button(
                    onClick = {
                        Log.d("PHOTO", photoBytes.size.toString())
                        Log.d("PHOTO", photoBytes.decodeToString())
                        if (memoryName.value.text.isEmpty() || selectedDateText.isEmpty()) {
                            return@Button
                        }

                        Log.d("PICKER", "Submitting memory")
                        val realm = RealmProvider().getRealm()
                        realm.writeBlocking {
                            val formatter = SimpleDateFormat("MM/dd/yyyy hh:mm")
                            val date: Date = formatter.parse(selectedDateText)

                            val lastLocation = fusedLocationClient.lastLocation
                            runBlocking { lastLocation.await() }

                            this.copyToRealm(Memory().apply{
                                name = memoryName.value.text
                                latitude = lastLocation.result.latitude
                                longitude = lastLocation.result.longitude
                                content = photoBytes
                                uploadedAt = System.currentTimeMillis() / 1000
                                unlockedAt = date.time / 1000
                            })
                        }

                    }
                ) {
                    Text(text = "Upload")
                }
            }
        }
    }
}
