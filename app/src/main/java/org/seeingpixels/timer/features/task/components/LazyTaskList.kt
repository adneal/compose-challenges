package org.seeingpixels.timer.features.task.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.seeingpixels.timer.features.task.data.Task
import org.seeingpixels.timer.theme.MaterialColors
import org.seeingpixels.timer.theme.MaterialTypography

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun LazyTaskList(
    tasks: List<Task>,
    modifier: Modifier = Modifier,
    onTaskClick: (Task) -> Unit = {}
) {
    val sortedTasks = tasks.sortedByDescending { it.priority }
    val rankedTasks = sortedTasks.groupBy { task -> task.priority }
    LazyColumn(modifier = modifier.fillMaxSize()) {
        rankedTasks.forEach { (priority, tasks) ->
            stickyHeader {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialColors.background
                ) {
                    Text(
                        text = priority.name,
                        color = MaterialColors.primary,
                        style = MaterialTypography.h5,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            items(tasks) { task ->
                TaskListItem(task = task) {
                    onTaskClick(task)
                }
            }
        }
    }
}