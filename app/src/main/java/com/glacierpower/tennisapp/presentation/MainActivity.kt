package com.glacierpower.tennisapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.glacierpower.tennisapp.R
import com.glacierpower.tennisapp.utils.getCurrentLocale
import com.glacierpower.tennisapp.utils.getStringByResId
import com.glacirepower.tennisapp.navigation.NavigationScreen
import com.lokalise.sdk.Lokalise
import com.lokalise.sdk.LokaliseResources
import dagger.hilt.android.AndroidEntryPoint
import theme.TennisTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TennisTheme {
                NavigationScreen()
            }
            val context = LocalContext.current
            val currentLocale = getCurrentLocale(context)
            Lokalise.setLocale(language = currentLocale.language)
            val lokalise = remember {
                LokaliseResources(context)
            }
            Column {
                Text(
                    text = lokalise.getStringByResId(context, R.string.account_details_title),
                    color = Color.Red,
                    modifier = Modifier.padding(top = 100.dp)
                )
            }
        }
    }
}
