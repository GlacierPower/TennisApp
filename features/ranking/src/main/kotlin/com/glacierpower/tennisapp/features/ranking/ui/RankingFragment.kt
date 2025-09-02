package com.glacierpower.tennisapp.features.ranking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.glacierpower.tennisapp.features.ranking.navigation.RankingNavigator
import com.glacierpower.tennisapp.features.ranking.ui.compose.RankingScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RankingFragment : Fragment() {
    @Inject
    lateinit var navigator: RankingNavigator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    RankingScreen(
                        onPlayerClick = { id -> navigator.navigateToProfile(id) }
                    )
                }
            }
        }
    }
}
