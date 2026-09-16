package com.codeshod.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onNavigate: (screen: Screen) -> Unit,
    isToolbarVisible: Boolean = true
) {

    if (isToolbarVisible) {
        TopAppBar(
            title = {
                Text(
                    text = "Settings",
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            navigationIcon = {
                IconButton(onClick = { onNavigate(Screen.PreviousScreen) }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                        contentDescription = "back_button"
                    )
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