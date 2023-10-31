package com.glacierpower.tennisapp.presentation.player_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.glacierpower.tennisapp.databinding.FragmentPlayerDetailsBinding
import com.glacierpower.tennisapp.presentation.adapter.PlayerDetailAdapter
import com.glacierpower.tennisapp.presentation.adapter.PlayerLastEventAdapter
import com.glacierpower.tennisapp.presentation.adapter.PlayerNearEventAdapter
import com.glacierpower.tennisapp.presentation.adapter.listener.Listener
import com.glacierpower.tennisapp.presentation.adapter.listener.NearEventListener
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerDetailsFragment : Fragment(), Listener, NearEventListener {


    private val viewModel: PlayerDetailsViewModel by viewModels()

    private var _viewBinding: FragmentPlayerDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var playerLAstEventAdapter: PlayerLastEventAdapter

    private lateinit var playerNearEventAdapter: PlayerNearEventAdapter

    private lateinit var playerDet: PlayerDetailAdapter

    private val args: PlayerDetailsFragmentArgs by navArgs()

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

        showPlayerNearEvents()

        showPlayerLastEvents()


        viewModel.nearEventLayout.observe(viewLifecycleOwner, Observer { nearEventLayout ->
            viewBinding.rvPlayerNearMatch.visibility = nearEventLayout
        })
    }


    private fun showPlayerDetails() {
        viewModel.getPlayerDetails(args.id)
        viewModel.playerDetails.observe(viewLifecycleOwner, Observer { playerDetails ->
            when (playerDetails) {
                is ResultState.Success -> {
                    playerDet.differ.submitList(listOf(playerDetails.data!!))
                    viewBinding.loadingLayout.visibility = View.GONE
                }
                is ResultState.Error -> {
                    viewBinding.tryAgainLayout.visibility =
                        View.VISIBLE
                }
                is ResultState.Loading -> {
                    viewBinding.loadingLayout.visibility =
                        View.VISIBLE
                }
            }
        })
    }


    private fun showPlayerNearEvents() {
        viewModel.getPlayerNearEvents(args.id)
        viewModel.playerNearEvents.observe(viewLifecycleOwner, Observer { playerNearEvents ->
            when (playerNearEvents) {
                is ResultState.Success -> {
                    playerNearEventAdapter.differ.submitList(listOf(playerNearEvents.data!!))
                    viewBinding.loadingLayout.visibility = View.GONE

                }
                is ResultState.Error -> {
                    viewBinding.tryAgainLayout.visibility =
                        View.VISIBLE
                }
                is ResultState.Loading -> {
                    viewBinding.loadingLayout.visibility =
                        View.VISIBLE
                }
            }


        })

    }


    private fun showPlayerLastEvents() {
        viewModel.getPlayerLastEvents(args.id)
        viewModel.playerLastEvents.observe(viewLifecycleOwner, Observer { playerLastEvents ->
            when (playerLastEvents) {
                is ResultState.Success -> {
                    playerLAstEventAdapter.differ.submitList(playerLastEvents.data?.sortedByDescending {
                        it.startTimestamp
                    })
                    viewBinding.rvPlayerLastMatch.visibility = View.VISIBLE
                }
                is ResultState.Error -> {
                    viewBinding.tryAgainLayout.visibility =
                        View.VISIBLE
                }
                is ResultState.Loading -> {
                    viewBinding.loadingLayout.visibility =
                        View.VISIBLE
                }
            }
        })
    }

    private fun setupRecyclerView() {

        playerLAstEventAdapter = PlayerLastEventAdapter(this)
        viewBinding.rvPlayerLastMatch.apply {
            setHasFixedSize(true)
            adapter = playerLAstEventAdapter

            playerDet = PlayerDetailAdapter()
            viewBinding.rvPlayerDetails.apply {
                setHasFixedSize(true)
                adapter = playerDet
            }

            playerNearEventAdapter = PlayerNearEventAdapter(this@PlayerDetailsFragment)
            viewBinding.rvPlayerNearMatch.apply {
                setHasFixedSize(true)
                adapter = playerNearEventAdapter
            }


        }
    }

    override fun getId(id: Int) {
        val action = PlayerDetailsFragmentDirections.actionPlayerDetailsToEventDetailsFragment(id)
        findNavController().navigate(
            action
        )

    }

    override fun getEventId(id: Int) {
        val action = PlayerDetailsFragmentDirections.actionPlayerDetailsToEventDetailsFragment(id)
        findNavController().navigate(
            action
        )
    }

}




