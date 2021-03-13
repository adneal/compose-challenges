package org.seeingpixels.bloom.common.modifier

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp

fun Modifier.textBaselineModifier(baseline: Dp) = layout { measurable, constraints ->
    val textPlaceable = measurable.measure(constraints)
    val firstTitleBaseline = textPlaceable[FirstBaseline].let { baseline ->
        if (baseline == AlignmentLine.Unspecified) null else baseline
    } ?: 0
    layout(width = textPlaceable.width, height = textPlaceable.height) {
        textPlaceable.place(x = 0, y = firstTitleBaseline + baseline.roundToPx())
    }
}