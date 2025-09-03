package com.glacierpower.tennisapp.features.ranking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.glacierpower.tennisapp.features.ranking.navigation.RankingNavigator
import com.glacierpower.tennisapp.features.ranking.ui.compose.RankingScreen
import dagger.hilt.android.AndroidEntryPoint
import theme.TennisTheme
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
                TennisTheme {
                    RankingScreen(
                        onPlayerClick = { id -> navigator.navigateToProfile(id) }
                    )
                }
            }
        }
    }
}
