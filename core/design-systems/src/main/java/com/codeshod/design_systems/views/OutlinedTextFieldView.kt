package com.codeshod.design_systems.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codeshod.design_systems.theme.GrayColor
import com.codeshod.design_systems.theme.TealColor

@Composable
fun OutlinedTextFieldView(
    text: String,
    label: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var value by rememberSaveable {
        mutableStateOf(text)
    }
    var isFocused by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
            value = newValue
        },
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            },
        label = {
            TextView(
                text = label,
                color = if (isFocused) {
                    TealColor
                } else {
                    GrayColor
                }
            )
        },
        textStyle = LocalTextStyle.current.copy(
            fontWeight = FontWeight.Normal,
            color = TealColor
        ),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = TealColor,
            unfocusedBorderColor = TealColor,
            cursorColor = TealColor
        )
    )
}