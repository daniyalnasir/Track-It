package com.codeshod.navigation.bottomBar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.codeshod.navigation.Screen
import com.codeshod.navigation.viewModel.HomeViewModel.BottomBarViewState

data class BottomBarNavigationItem(
    val icon: Int,
    val route: Screen
)

@Composable
fun BottomNavigationBar(
    bottomBarViewState: BottomBarViewState,
    onNavigate: (Screen) -> Unit,
) {

    if (bottomBarViewState.isVisible) {
        NavigationBar(
            containerColor = Color.White
        ) {
            bottomBarNavigationItems.forEachIndexed { _, item ->
                NavigationBarItem(
                    selected = bottomBarViewState.selectedBottomBarNavigationItem?.route == item.route,
                    onClick = {
                        onNavigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(item.icon),
                            contentDescription = item.route.title
                        )
                    },
                    label = {
                        Text(
                            item.route.title,
                            color = if (bottomBarViewState.selectedBottomBarNavigationItem?.route == item.route) {
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
}