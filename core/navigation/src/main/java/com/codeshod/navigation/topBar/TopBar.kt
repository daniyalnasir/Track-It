package com.codeshod.navigation.topBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codeshod.design_systems.AppDrawables
import com.codeshod.navigation.Screen
import com.codeshod.navigation.viewModel.HomeViewModel.TopBarViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    topBarViewState: TopBarViewState,
    currentScreen: Screen?,
    onNavigate: (screen: Screen) -> Unit,
    isToolbarVisible: Boolean = true
) {
    if (isToolbarVisible) {
        TopAppBar(
            title = {
                if (currentScreen is Screen.Dashboard) {
                    DashboardContent("Daniyal Nasir")
                } else {
                    Text(
                        text = topBarViewState.title,
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
            ),
            navigationIcon = {
                if (topBarViewState.isBackNavigationButtonVisible) {
                    IconButton(onClick = { onNavigate(Screen.PreviousScreen) }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(AppDrawables.back),
                            contentDescription = "back_button"
                        )
                    }
                }
            },
            actions = {
//                IconButton(onClick = {  }) {
//                    Icon(
//                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
//                        contentDescription = "back_button"
//                    )
//                }
            }
        )
    }
}

@Composable
fun DashboardContent(
    userName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Good afternoon,",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f)
            )

            Text(
                text = userName,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}