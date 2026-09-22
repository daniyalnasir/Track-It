package com.codeshod.navigation

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.codeshod.design_systems.AppDrawables

@Composable
fun FloatingButton(
    onNavigate: (screen: Screen) -> Unit,
) {

    FloatingActionButton(
        onClick = {
            onNavigate(Screen.AddTransaction)
        }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(AppDrawables.add),
            contentDescription = "Add Item"
        )
    }
}