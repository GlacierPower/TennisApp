package com.glacierpower.tennisapp.presentation.live_events

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.glacierpower.tennisapp.databinding.FragmentLiveEventBinding
import com.glacierpower.tennisapp.presentation.adapter.LiveEventAdapter
import com.glacierpower.tennisapp.presentation.adapter.listener.LiveEventListener
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveEventFragment : Fragment(),LiveEventListener {

    private val viewModel: LiveEventViewModel by viewModels()

    private var _viewBinding: FragmentLiveEventBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var liveEventAdapter: LiveEventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLiveEventBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        observeInternetConnection()

        getLiveEvent()
    }

    private fun observeInternetConnection() {
        viewModel.connection.observe(viewLifecycleOwner) {
            it.let { connection ->
                if (connection) {
                    viewBinding.tryAgainLayout.visibility = View.VISIBLE
                    viewBinding.rvLiveEvent.visibility = View.INVISIBLE
                } else {
                    viewBinding.tryAgainLayout.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun setupRecyclerView() {
        liveEventAdapter = LiveEventAdapter(this)
        viewBinding.rvLiveEvent.apply {
            setHasFixedSize(true)
            adapter = liveEventAdapter
        }
    }

    private fun getLiveEvent() {
        viewModel.getLiveEvent()
        viewModel.liveEvent.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ResultState.Success -> {
                    liveEventAdapter.differ.submitList(response.data!!)
                    viewBinding.rvLiveEvent.visibility = View.VISIBLE
                    viewBinding.loadingLayout.visibility = View.GONE
                }
                is ResultState.Error -> {
                    viewBinding.tryAgainLayout.visibility = View.VISIBLE
                }
                is ResultState.Loading -> {
                    viewBinding.loadingLayout.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun getTournamentImage(id: Int) {
        viewModel.getTournamentImage(id)
    }


}

