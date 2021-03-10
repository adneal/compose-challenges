package org.seeingpixels.timer.features.task.data

data class Task(
    var title: String,
    var description: String? = null,
    var priority: TaskPriority = TaskPriority.Low,
    var completed: Boolean = false
)