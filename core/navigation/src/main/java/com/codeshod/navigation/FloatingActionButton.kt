package com.codeshod.navigation

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun FloatingButton() {

    FloatingActionButton(
        onClick = {

        }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_add),
            contentDescription = "Add Item"
        )
    }

}