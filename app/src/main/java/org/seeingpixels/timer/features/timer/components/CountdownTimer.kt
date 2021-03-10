package org.seeingpixels.timer.features.timer.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import org.seeingpixels.timer.common.components.Spacing
import org.seeingpixels.timer.features.timer.data.Holiday
import org.seeingpixels.timer.features.timer.effects.rememberTime
import kotlin.time.ExperimentalTime

@Composable
fun CountdownTimer(holiday: Holiday) {
    val holidayCalendar = remember {
        Calendar.getInstance().apply {
            if (holiday.month < get(Calendar.MONTH)) {
                set(Calendar.YEAR, get(Calendar.YEAR) + 1)
            }
            set(Calendar.MONTH, holiday.month)
            set(Calendar.DAY_OF_MONTH, holiday.dayOfMonth)
        }
    }
    val (days, hours, minutes, seconds) = rememberTime(holidayCalendar.timeInMillis)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(holiday.gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = holiday.name,
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )
        Spacing.SmallVerticalSpacer()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberBox("days", days)
            Spacing.SmallHorizontalSpacer()
            NumberBox("hours", hours)
            Spacing.SmallHorizontalSpacer()
            NumberBox("minutes", minutes)
            Spacing.SmallHorizontalSpacer()
            NumberBox("seconds", seconds)
        }
    }
}

@Composable
@OptIn(ExperimentalTime::class)
private fun NumberBox(
    label: String,
    time: Long
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.White
        )
        Surface(
            color = Color.Black,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "$time",
                fontSize = 48.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
            )
        }
    }
}