package com.glacierpower.tennisapp.presentation.event_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import com.glacierpower.tennisapp.databinding.FragmentEventDetailsBinding
import com.glacierpower.tennisapp.presentation.adapter.EventDetailsAdapter
import com.glacierpower.tennisapp.presentation.adapter.EventStatisticsAdapter
import com.glacierpower.tennisapp.presentation.adapter.EventSummaryAdapter
import com.glacierpower.tennisapp.presentation.adapter.listener.Listener
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDetailsFragment : Fragment(), Listener {

    private val viewModel: EventDetailsViewModel by viewModels()

    private val args: EventDetailsFragmentArgs by navArgs()

    private lateinit var eventSummaryAdapter: EventSummaryAdapter

    private lateinit var eventDetailsAdapter: EventDetailsAdapter

    private lateinit var eventStatisticsAdapter: EventStatisticsAdapter


    private var _viewBinding: FragmentEventDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentEventDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        showEventDetails()

        showEventStatistics()

    }

    private fun showEventDetails() {
        viewModel.eventDetails.observe(viewLifecycleOwner, Observer { eventDetails ->
            when (eventDetails) {
                is ResultState.Success -> {
                    eventDetailsAdapter.differ.submitList(listOf(eventDetails.data))
                    viewBinding.summary.setOnClickListener {
                        eventSummaryAdapter.differ.submitList(listOf(eventDetails.data!!))
                    }
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

    private fun showEventStatistics() {
        viewModel.getEventStatistics(args.id)
        viewModel.getEventDetails(args.id)
        viewModel.eventStatistics.observe(viewLifecycleOwner, Observer { eventStatistics ->
            when (eventStatistics) {
                is ResultState.Success -> {
                    eventStatisticsAdapter.differ.submitList(listOf(eventStatistics.data!!))
                    viewBinding.rvStatistics.visibility = View.VISIBLE
                    viewBinding.loadingLayout.visibility = View.GONE
                }
                is ResultState.Error -> {
                    viewBinding.tryAgainLayout.visibility = View.VISIBLE
                }
                is ResultState.Loading -> {
                    viewBinding.loadingLayout.visibility = View.VISIBLE
                }
            }

        })
    }

    private fun setupRecyclerView() {
        eventDetailsAdapter = EventDetailsAdapter(this)
        viewBinding.rvPlayerDetails.apply {
            setHasFixedSize(true)
            adapter = eventDetailsAdapter
        }

        eventSummaryAdapter = EventSummaryAdapter()
        viewBinding.rvSummaryEvent.apply {
            setHasFixedSize(true)
            adapter = eventSummaryAdapter
        }

        eventStatisticsAdapter = EventStatisticsAdapter()
        val snapHelper = PagerSnapHelper()

            viewBinding.rvStatistics.apply {
                snapHelper.attachToRecyclerView(this)
                setHasFixedSize(true)
                adapter = eventStatisticsAdapter

        }


    }

    override fun getId(id: Int) {
        val action =
            EventDetailsFragmentDirections.actionEventDetailsFragmentToPlayerDetails(id)
        findNavController().navigate(action)
    }
}