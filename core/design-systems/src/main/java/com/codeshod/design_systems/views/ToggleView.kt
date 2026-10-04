package com.codeshod.design_systems.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codeshod.design_systems.theme.GrayColor
import com.codeshod.design_systems.theme.TealColor
import com.codeshod.design_systems.theme.WhiteColor
import com.codeshod.design_systems.theme.WhiteSmokeColor
import com.codeshod.design_systems.theme.transparentColor

@Composable
fun ToggleView(
    toggleItems: Array<String>,
    onSelectionChanged: (String) -> Unit
) {
    var selectedToggle by rememberSaveable {
        mutableIntStateOf(1)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(
                color = WhiteSmokeColor,
                shape = RoundedCornerShape(32.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ToggleItem(
            text = toggleItems[0],
            selected = selectedToggle == 1,
            modifier = Modifier.weight(1f),
            onClick = {
                selectedToggle = 1
                onSelectionChanged(toggleItems[0])
            }
        )

        ToggleItem(
            text = toggleItems[1],
            selected = selectedToggle == 2,
            modifier = Modifier.weight(1f),
            onClick = {
                selectedToggle = 2
                onSelectionChanged(toggleItems[1])
            }
        )
    }
}

@Composable
private fun ToggleItem(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(28.dp))
            .background(
                color = if (selected) {
                    TealColor
                } else {
                    transparentColor
                }
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        TextView(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) {
                WhiteColor
            } else {
                GrayColor
            }
        )
    }
}