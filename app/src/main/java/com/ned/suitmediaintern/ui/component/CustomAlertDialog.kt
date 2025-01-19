package com.ned.suitmediaintern.ui.component


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CustomAlertDialog(
    title: String,
    message: String,
    onDismissRequest: () -> Unit,
    onConfirmButton: () -> Unit = {},
    showConfirmButton: Boolean = false,
    confirmButtonText: String = "OK",
    dismissButtonText: String = "OK"
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        text = {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        },
        confirmButton = {
            if (showConfirmButton) {
                TextButton(onClick = {
                    onConfirmButton()
                    onDismissRequest()
                }) {
                    Text(text = confirmButtonText)
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = dismissButtonText)
            }
        }
    )
}