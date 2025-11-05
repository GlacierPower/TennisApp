package com.glacierpower.tennisapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.glacierpower.tennisapp.utils.getCurrentLocale
import com.glacirepower.tennisapp.navigation.NavigationScreen
import com.lokalise.sdk.Lokalise
import com.lokalise.sdk.LokaliseCallback
import com.lokalise.sdk.LokaliseUpdateError
import dagger.hilt.android.AndroidEntryPoint
import theme.TennisTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isLoading = remember { mutableStateOf(true) }
            val context = LocalContext.current
            val currentLocale = getCurrentLocale(context)
            Lokalise.setLocale(language = currentLocale.language)
            Lokalise.addCallback(object : LokaliseCallback {
                override fun onUpdateFailed(error: LokaliseUpdateError) {
                    isLoading.value = false
                }

                override fun onUpdateNotNeeded() {
                    isLoading.value = false
                }

                override fun onUpdated(oldBundleId: Long, newBundleId: Long) {
                    if (newBundleId != 0L) {
                        isLoading.value = false
                    }
                }
            })
            if (isLoading.value) { // Here can hande showing splash screen
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                TennisTheme {
                    NavigationScreen()
                }
            }
        }
    }
}
