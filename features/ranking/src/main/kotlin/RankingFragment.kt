package com.glacierpower.tennisapp.presentation.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.glacierpower.tennisapp.features.ranking.R
import com.glacierpower.tennisapp.features.ranking.databinding.FragmentRankingBinding
import com.glacierpower.tennisapp.presentation.ranking.adapter.RankingAdapter
import com.glacierpower.tennisapp.presentation.ranking.adapter.adapter.Listener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RankingFragment : Fragment(), Listener {
    private val rankingViewModel: RankingViewModel by viewModels()

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
        observeLoadingState()
//        observeInternetConnection()

        getRanking()


    }
//    private fun observeInternetConnection(){
//
//        rankingViewModel.connection.observe(viewLifecycleOwner, Observer {
//            it.let {
//                if (it) {
//                    viewBinding.tryAgainLayout.visibility = View.VISIBLE
//                    viewBinding.rvRanking.visibility = View.INVISIBLE
//                } else {
//                    viewBinding.tryAgainLayout.visibility =
//                        View.INVISIBLE
//                }
//            }
//        })
//    }

    private fun getRanking() {
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
                            rankingViewModel.ranking.observe(
                                viewLifecycleOwner,
                                Observer { response ->
                                    rankingAdapter.submitCompetitorsList(response.first().competitorRankings)
                                    viewBinding.loadingLayout.visibility = View.GONE
                                    viewBinding.title.text = response.first().name
                                })
                        }

                        1 -> {
                            rankingViewModel.ranking.observe(
                                viewLifecycleOwner,
                                Observer { response ->
                                    rankingAdapter.submitCompetitorsList(response.last().competitorRankings)
                                    viewBinding.loadingLayout.visibility = View.GONE
                                    viewBinding.title.text = response.last().name
                                })
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    rankingViewModel.ranking.observe(
                        viewLifecycleOwner,
                        Observer { response ->
                            rankingAdapter.submitCompetitorsList(response.first().competitorRankings)
                            viewBinding.loadingLayout.visibility = View.GONE
                            viewBinding.title.text = response.first().name
                        })
                }
            }
    }

    private fun observeLoadingState() {
        rankingViewModel.isLoading.observe(viewLifecycleOwner, Observer { state ->
            state.let { isLoading ->
                if (isLoading) {
                    viewBinding.loadingLayout.visibility = View.VISIBLE
                } else {
                    viewBinding.loadingLayout.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun setupRecyclerView() {

        rankingAdapter = RankingAdapter(this)
        viewBinding.rvRanking.apply {
            setHasFixedSize(true)
            adapter = rankingAdapter

        }
    }

    private fun setupSpinner() {
        val ranking = resources.getStringArray(R.array.Ranking)
        val spinnerAdapter =
            ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                ranking
            )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(viewBinding.spinner) {
            adapter = spinnerAdapter
            setSelection(
                spinnerAdapter.getPosition(context.getString(R.string.adapter_position_ranking)),
                false
            )
        }
    }

    override fun getId(id: Int) {

    }
}
