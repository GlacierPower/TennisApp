package com.glacierpower.tennisapp.domain.search

import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel
import com.glacierpower.tennisapp.utils.ResultState
import javax.inject.Inject

class SearchInteractor @Inject constructor(
    private val searchRepository: SearchRepository
) {

    suspend fun playerSearch(query: String): ResultState<List<SearchResultModel>> {
        return searchRepository.playerSearch(query)
    }
}