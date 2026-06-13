package com.example.mycoffeeapp.presentation.ui_components

import android.icu.text.CaseMap
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppDialog(isShow: Boolean, title: String, message: String, onDismiss: () -> Unit) {

    if (isShow){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = title)
            },
            text = {
                Text(text = message)
            },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "OK")
                }
            }
        )
    }
}