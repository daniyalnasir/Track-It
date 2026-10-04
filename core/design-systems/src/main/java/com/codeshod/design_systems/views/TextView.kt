package com.codeshod.design_systems.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.codeshod.design_systems.EMPTY_STRING
import com.codeshod.design_systems.theme.GrayColor

@Composable
fun TextView(
    modifier: Modifier = Modifier,
    isTitleAllCaps: Boolean = true,
    text: String = EMPTY_STRING,
    style: TextStyle = MaterialTheme.typography.titleSmall,
    color: Color = GrayColor,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 1,
    textDecoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Visible,
) {
    Text(
        text = if (isTitleAllCaps) {
            text.uppercase()
        } else {
            text
        },
        style = style,
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize,
        textAlign = textAlign,
        maxLines = maxLines,
        textDecoration = textDecoration,
        overflow = overflow,
        modifier = modifier,
    )
}
