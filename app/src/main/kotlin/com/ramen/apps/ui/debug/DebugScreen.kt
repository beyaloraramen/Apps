package com.ramen.apps.ui.debug

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DebugScreen(error: String?) {
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()
    SelectionContainer {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .horizontalScroll(horizontalScrollState)
                .verticalScroll(verticalScrollState)
        ) {
            Text(
                text = if (error.isNullOrBlank()) "No error available!" else error,
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}
