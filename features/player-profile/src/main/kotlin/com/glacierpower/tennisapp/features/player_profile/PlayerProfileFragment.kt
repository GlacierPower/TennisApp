package com.glacierpower.tennisapp.features.player_profile

import adapter.PlayerProfileAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.glacierpower.tennisapp.features.player_profile.adapter.PlayerSummariesAdapter
import com.glacierpower.tennisapp.features.player_profile.databinding.FragmentPlayerDetailsBinding
import com.glacierpower.tennisapp.features.player_profile.navigation.PlayerProfileNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayerProfileFragment : Fragment() {

    @Inject
    lateinit var playerProfileNavigator: PlayerProfileNavigator
    private val viewModel: PlayerProfileViewModel by viewModels()

    private var _viewBinding: FragmentPlayerDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var playerDetailsAdapter: PlayerProfileAdapter

    private lateinit var playerSummariesAdapter: PlayerSummariesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "New Fragment Title"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentPlayerDetailsBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        showPlayerDetails()

    }

    private fun showPlayerDetails() {
        viewModel.getPlayerDetails()
        viewModel.playerDetails.observe(viewLifecycleOwner, Observer { playerDetails ->
            playerDetailsAdapter.differ.submitList(listOf(playerDetails))
        })
        viewModel.playerSummaries.observe(viewLifecycleOwner, Observer{ playersSummaries->
            playerSummariesAdapter.differ.submitList(listOf(playersSummaries))
        })
    }

    private fun setupRecyclerView() {
        playerDetailsAdapter = PlayerProfileAdapter()
        viewBinding.rvPlayerDetails.apply {
            setHasFixedSize(true)
            adapter = playerDetailsAdapter

        }
        playerSummariesAdapter = PlayerSummariesAdapter()
        viewBinding.rvPlayerLastMatch.apply {
            setHasFixedSize(true)
            adapter = playerSummariesAdapter
        }
    }
}




