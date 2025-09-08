package com.glacierpower.tennisapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.glacirepower.tennisapp.navigation.NavigationScreen
import dagger.hilt.android.AndroidEntryPoint
import theme.TennisTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TennisTheme {
                NavigationScreen()
            }
        }
    }
}
