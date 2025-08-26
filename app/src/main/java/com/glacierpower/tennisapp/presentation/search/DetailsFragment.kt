package com.glacierpower.tennisapp.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.glacierpower.tennisapp.databinding.FragmentSearchBinding
import com.glacierpower.tennisapp.presentation.adapter.SearchAdapter
import com.glacierpower.tennisapp.presentation.adapter.listener.Listener
import com.glacierpower.tennisapp.utils.Constants.DELAY
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment(), Listener {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _viewBinding: FragmentSearchBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var searchAdapter: SearchAdapter
    private var job: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSearchBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        observeInternetConnection()

        searchPlayer()

        observeSearchLiveData()


    }

    private fun observeInternetConnection() {
        searchViewModel.connection.observe(requireActivity(), Observer {
            it.let {
                if (it) {
                    viewBinding.tryAgainLayout.visibility = View.VISIBLE
                    viewBinding.rvSearchPlayer.visibility = View.INVISIBLE
                } else {
                    viewBinding.tryAgainLayout.visibility =
                        View.INVISIBLE
                }
            }
        })
    }

    private fun searchPlayer() {

        viewBinding.searchView.setOnQueryTextListener(
            object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    job?.cancel()
                    job = viewLifecycleOwner.lifecycleScope.launch {
                        delay(DELAY)
                        if (newText?.length!! >= 3) {
                            searchViewModel.searchPlayer(newText)
                        }
                    }
                    return false
                }

            }
        )

    }

    private fun setupRecyclerView() {
        searchAdapter = SearchAdapter(this)
        viewBinding.rvSearchPlayer.apply {
            setHasFixedSize(true)
            adapter = searchAdapter
        }
    }

    private fun observeSearchLiveData() {
        searchViewModel.search.observe(viewLifecycleOwner, Observer { searchResult ->
            when (searchResult) {
                is ResultState.Success -> {
                    searchResult.data?.let { list ->
                        searchAdapter.differ.submitList(list.toList())
                        viewBinding.loadingLayout.visibility = View.GONE
                    }
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

    override fun getId(id: Int) {
        val action = DetailsFragmentDirections.actionSearchFragmentToPlayerDetails(id)
        findNavController().navigate(
            action
        )
    }

}
