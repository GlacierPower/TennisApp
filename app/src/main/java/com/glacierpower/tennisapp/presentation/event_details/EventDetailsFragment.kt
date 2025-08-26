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
import com.glacierpower.tennisapp.databinding.FragmentEventDetailsBinding
import com.glacierpower.tennisapp.presentation.adapter.EventDetailsAdapter
import com.glacierpower.tennisapp.presentation.adapter.listener.Listener
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDetailsFragment : Fragment(), Listener {

    private val viewModel: EventDetailsViewModel by viewModels()

    private val args: EventDetailsFragmentArgs by navArgs()

    private val detailsArgs: EventDetailsFragmentArgs by navArgs()

    private lateinit var eventDetailsAdapter: EventDetailsAdapter

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

    }

    private fun showEventDetails() {
        viewModel.getEventDetails(args.id)
        viewModel.eventDetails.observe(viewLifecycleOwner, Observer { eventDetails ->
            when (eventDetails) {
                is ResultState.Success -> {
                    eventDetailsAdapter.differ.submitList(listOf(eventDetails.data))
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

    private fun setupRecyclerView() {
        eventDetailsAdapter = EventDetailsAdapter(this)
        viewBinding.rvPlayerDetails.apply {
            setHasFixedSize(true)
            adapter = eventDetailsAdapter
        }
    }

    override fun getId(id: Int) {
        val action =
            EventDetailsFragmentDirections.actionEventDetailsFragmentToPlayerDetails(id)
        findNavController().navigate(action)
    }
}