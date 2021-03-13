package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.app.components.BloomBottomNavigation
import org.seeingpixels.bloom.features.home.data.DummyPlants
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BloomBottomNavigation()
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                stickyHeader {
                    OutlinedTextField(
                        value = "",
                        leadingIcon = {
                            Image(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = "search",
                                colorFilter = ColorFilter.tint(MaterialColors.onBackground),
                                modifier = Modifier.size(18.dp)
                            )
                        },
                        placeholder = { Text(text = "Search", style = MaterialTypography.body1) },
                        onValueChange = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialColors.background)
                            .padding(16.dp)
                    )
                }
                item {
                    SectionTitle(title = "Browse Themes")
                }
                item {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        items(DummyPlants) { plant ->
                            BrowseThemeItem(plant)
                        }
                    }
                }
                item {
                    SectionTitle(
                        title = "Design your home garden",
                        icon = Icons.Rounded.FilterList,
                        iconButtonContentDescription = "filter list"
                    )
                }
                items(DummyPlants) { plant ->
                    GardenListItem(plant)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    )
}

@Composable
private fun SectionTitle(
    title: String,
    icon: ImageVector? = null,
    iconButtonContentDescription: String? = null,
    onIconClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTypography.h1
        )
        if (icon != null) IconButton(
            onClick = { if (onIconClick != null) onIconClick() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        ) {
            Icon(imageVector = icon, contentDescription = iconButtonContentDescription)
        }
    }
}