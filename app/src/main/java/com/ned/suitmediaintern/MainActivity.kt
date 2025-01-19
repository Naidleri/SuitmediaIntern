package com.ned.suitmediaintern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ned.suitmediaintern.ui.presentation.firstscreen.FirstScreen
import com.ned.suitmediaintern.ui.theme.SuitmediaInternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuitmediaInternTheme {
               FirstScreen()
            }
        }
    }
}
