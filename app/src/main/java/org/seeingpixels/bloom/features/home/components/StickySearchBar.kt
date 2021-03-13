package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.MaterialTypography

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.stickySearchBar() = stickyHeader {
    var query by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query,
        leadingIcon = {
            Image(
                imageVector = Icons.Rounded.Search,
                contentDescription = "search",
                colorFilter = ColorFilter.tint(MaterialColors.onBackground),
                modifier = Modifier.size(18.dp)
            )
        },
        placeholder = { Text(text = "Search", style = MaterialTypography.body1) },
        onValueChange = { query = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialColors.background)
            .padding(16.dp)
    )
}