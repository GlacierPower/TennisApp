package com.glacierpower.tennisapp.features.player_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.glacierpower.tennisapp.features.player_profile.ui.compose.PlayerProfileScreen
import com.glacierpower.tennisapp.features.player_profile.navigation.PlayerProfileNavigator
import dagger.hilt.android.AndroidEntryPoint
import theme.TennisTheme
import javax.inject.Inject

@AndroidEntryPoint
class PlayerProfileFragment : Fragment() {

    @Inject
    lateinit var playerProfileNavigator: PlayerProfileNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "New Fragment Title"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            TennisTheme {
                PlayerProfileScreen(
                    onNavigateBack = { playerProfileNavigator.navigateBack() }
                )
            }
        }
    }
}
