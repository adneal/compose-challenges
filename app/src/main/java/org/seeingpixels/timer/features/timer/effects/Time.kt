package org.seeingpixels.timer.features.timer.effects

import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.util.*
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.isActive

@Composable
fun rememberTime(endDateTime: Long): Time {
    val now = remember { Calendar.getInstance() }
    var days by remember { mutableStateOf(0L) }
    var hours by remember { mutableStateOf(0L) }
    var minutes by remember { mutableStateOf(0L) }
    var seconds by remember { mutableStateOf(0L) }
    LaunchedEffect(now) {
        while (isActive) {
            withInfiniteAnimationFrameMillis {
                val diff = endDateTime - now.timeInMillis
                now.timeInMillis = System.currentTimeMillis()
                days = TimeUnit.MILLISECONDS.toDays(diff)
                hours = TimeUnit.MILLISECONDS.toHours(diff) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(diff))
                minutes = TimeUnit.MILLISECONDS.toMinutes(diff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff))
                seconds = TimeUnit.MILLISECONDS.toSeconds(diff) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff))
            }
        }
    }
    return Time(days, hours, minutes, seconds)
}

data class Time(
    val days: Long,
    val hours: Long,
    val minutes: Long,
    val seconds: Long
)