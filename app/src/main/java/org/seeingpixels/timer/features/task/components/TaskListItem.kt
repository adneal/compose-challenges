package org.seeingpixels.timer.features.task.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.seeingpixels.timer.common.components.Spacing
import org.seeingpixels.timer.features.task.data.Task
import org.seeingpixels.timer.theme.MaterialTypography

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun TaskListItem(
    task: Task,
    modifier: Modifier = Modifier,
    onTaskClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clickable(onClick = onTaskClick)
    ) {
        ListItem(
            text = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = task.priority.color.copy(alpha = 0.4f),
                                shape = CircleShape
                            )
                            .border(
                                width = 1.dp,
                                color = task.priority.color,
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                    )
                    Spacing.MediumHorizontalSpacer()
                    Text(
                        text = task.title,
                        style = MaterialTypography.h5
                    )
                }
            },
            secondaryText = {
                Column {
                    task.description?.let { description ->
                        Text(
                            text = description,
                            style = MaterialTypography.body1
                        )
                        Spacing.SmallVerticalSpacer()
                    }
                }
            }

        )
    }
}