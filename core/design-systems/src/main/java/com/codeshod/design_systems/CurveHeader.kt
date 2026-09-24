package com.codeshod.design_systems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

private val HEADER_CURVE_HEIGHT = 250.dp
val HEADER_CURVE_HEIGHT_WITHOUT_TOPBAR = HEADER_CURVE_HEIGHT - 130.dp

@Composable
fun CurvedHeader(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(HEADER_CURVE_HEIGHT)
                .clip(HeaderShape())
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        content()
    }
}