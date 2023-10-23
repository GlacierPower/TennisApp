package com.glacierpower.tennisapp.presentation.player_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.glacierpower.tennisapp.databinding.FragmentPlayerDetailsBinding
import com.glacierpower.tennisapp.presentation.adapter.PlayerDetailsAdapter
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.Extensions.convertToString
import com.glacierpower.tennisapp.utils.ResultState
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerDetailsFragment : Fragment() {


    private val viewModel: PlayerDetailsViewModel by viewModels()

    private var _viewBinding: FragmentPlayerDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var playerDetailsAdapter: PlayerDetailsAdapter

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

        showDate()

        viewModel.nearEventLayout.observe(viewLifecycleOwner, Observer {nearEventLayout ->
            viewBinding.eventLayout.visibility = nearEventLayout
        })
    }


    private fun showPlayerDetails() {
        viewModel.getPlayerDetails(args.id)
        viewModel.playerDetails.observe(viewLifecycleOwner, Observer { playerDetails ->
            when (playerDetails) {
                is ResultState.Success -> {
                    viewBinding.playerName.text = playerDetails.data?.fullName
                    viewBinding.countryName.text = playerDetails.data?.country?.name
                    viewBinding.tournamentType.text = playerDetails.data?.tournament?.category?.name
                    viewBinding.ranking.text = playerDetails.data?.ranking.toString()

                    Picasso.get()
                        .load("${Constants.TEAM_IMAGE_URL}${args.id}${Constants.IMAGE_KEY}")
                        .into(viewBinding.playerImage)
                    Picasso.get()
                        .load("${Constants.FLAG_URL}${playerDetails.data?.country?.alpha2}${Constants.IMAGE_FORMAT}")
                        .into(viewBinding.countryFlag)

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
                    viewBinding.awayTeam.text = playerNearEvents.data?.nextEvent?.homeTeam?.name
                    viewBinding.homeTeam.text = playerNearEvents.data?.nextEvent?.awayTeam?.name

                    viewBinding.tournament.text = playerNearEvents.data?.nextEvent?.tournament?.name
                    viewBinding.tournamentCategory.text =
                        playerNearEvents.data?.nextEvent?.tournament?.category?.name

                    val id = playerNearEvents.data!!.nextEvent?.tournament?.uniqueTournament?.id
                    Picasso.get()
                        .load("${Constants.TOURNAMENT_URL}${id}${Constants.IMAGE_KEY}")
                        .into(viewBinding.tournamentImage)

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

    private fun showDate() {
        viewModel.convertTime.observe(viewLifecycleOwner, Observer { time ->
            viewBinding.tournamentDate.text = time?.convertToString(time)
        })
    }

    private fun showPlayerLastEvents() {
        viewModel.getPlayerLastEvents(args.id)
        viewModel.playerLastEvents.observe(viewLifecycleOwner, Observer { playerLastEvents ->
            when (playerLastEvents) {
                is ResultState.Success -> {
                    playerDetailsAdapter.differ.submitList(playerLastEvents.data?.sortedByDescending {
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

        playerDetailsAdapter = PlayerDetailsAdapter()
        viewBinding.rvPlayerLastMatch.apply {
            setHasFixedSize(true)
            adapter = playerDetailsAdapter

        }
    }

}




