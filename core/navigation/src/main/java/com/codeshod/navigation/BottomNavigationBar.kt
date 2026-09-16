package com.codeshod.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

data class NavigationItem(
    val title: String,
    val icon: Int,
    val route: Screen
)

private val navigationItems = listOf(
    NavigationItem(
        title = "Dashboard",
        icon = R.drawable.ic_dashboard,
        route = Screen.Dashboard
    ),
    NavigationItem(
        title = "Stats",
        icon = R.drawable.ic_stats,
        route = Screen.Stats
    ),
    NavigationItem(
        title = "Categories",
        icon = R.drawable.ic_category,
        route = Screen.Categories
    ),
    NavigationItem(
        title = "Settings",
        icon = R.drawable.ic_settings,
        route = Screen.Settings
    )
)

@Composable
fun BottomNavigationBar(
    onNavigate: (screen: Screen) -> Unit,
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    onNavigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue) {
                            Color.Black
                        } else {
                            Color.Gray
                        }
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}