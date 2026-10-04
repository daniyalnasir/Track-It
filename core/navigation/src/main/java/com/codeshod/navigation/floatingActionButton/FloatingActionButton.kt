package com.codeshod.navigation.floatingActionButton

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.codeshod.design_systems.AppDrawables
import com.codeshod.navigation.Screen
import com.codeshod.navigation.viewModel.HomeViewModel.FloatingActionButtonViewState

@Composable
fun FloatingActionButton(
    floatingActionButtonViewState: FloatingActionButtonViewState,
    onNavigate: (screen: Screen) -> Unit,
) {

    if (floatingActionButtonViewState.isVisible) {
        FloatingActionButton(
            onClick = {
                floatingActionButtonViewState.navigateTo?.let { onNavigate(it) }
            }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(AppDrawables.add),
                contentDescription = "Add Item"
            )
        }
    }
}