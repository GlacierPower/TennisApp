package com.glacierpower.tennisapp.presentation.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.glacierpower.tennisapp.R
import com.glacierpower.tennisapp.databinding.FragmentRankingBinding
import com.glacierpower.tennisapp.presentation.adapter.RankingAdapter
import com.glacierpower.tennisapp.presentation.adapter.listener.Listener
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RankingFragment : Fragment(),Listener
{

    private val viewModel: RankingViewModel by viewModels()

    private lateinit var rankingAdapter: RankingAdapter

    private var _viewBinding: FragmentRankingBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRankingBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupSpinner()

        observeInternetConnection()

        getRanking()



    }
    private fun observeInternetConnection(){

        viewModel.connection.observe(viewLifecycleOwner, Observer {
            it.let {
                if (it) {
                    viewBinding.tryAgainLayout.visibility = View.VISIBLE
                    viewBinding.rvRanking.visibility = View.INVISIBLE
                } else {
                    viewBinding.tryAgainLayout.visibility =
                        View.INVISIBLE
                }
            }
        })
    }

    private fun setupRecyclerView(){

        rankingAdapter = RankingAdapter(this)
        viewBinding.rvRanking.apply {
            setHasFixedSize(true)
            adapter = rankingAdapter

        }
    }

    private fun setupSpinner(){

        val ranking = resources.getStringArray(R.array.Ranking)
        val spinnerAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, ranking)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(viewBinding.spinner) {
            adapter = spinnerAdapter
            setSelection(
                spinnerAdapter.getPosition(context.getString(R.string.adapter_position_ranking)),
                false
            )
        }
    }

    private fun getRanking(){
        viewBinding.spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (position) {
                        0 -> {
                            getAtpRanking()
                        }
                        1 -> {
                            getWtaRanking()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.nothing_selected),
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

            }
    }

    private fun getAtpRanking() {
        viewModel.getAtpRanking()
        viewBinding.title.text = getString(R.string.atp_single)
        viewModel.ranking.observe(
            viewLifecycleOwner,
            Observer { response ->
                when (response) {
                    is ResultState.Success -> {
                        rankingAdapter.differ.submitList(response.data!!)
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

    private fun getWtaRanking() {
        viewModel.getWtaRanking()
        viewBinding.title.text = getString(R.string.wta_single)
        viewModel.ranking.observe(
            viewLifecycleOwner,
            Observer { response ->
                when (response) {
                    is ResultState.Success -> {
                        rankingAdapter.differ.submitList(response.data!!)
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

    override fun getId(id: Int) {
        val action = RankingFragmentDirections.actionRankingFragmentToPlayerDetails(id)
        findNavController().navigate(
            action
        )
    }
}
