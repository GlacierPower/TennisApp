package com.glacierpower.tennisapp.data.repositoryImpl

import android.util.Log
import android.view.View
import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.search.SearchRepository
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel
import com.glacierpower.tennisapp.utils.Constants.IMAGE_KEY
import com.glacierpower.tennisapp.utils.Constants.TEAM_IMAGE_URL
import com.glacierpower.tennisapp.utils.ResultState
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class SearchRepositoryImpl @Inject constructor(
    @Named("Tennis") private val tennisApiService: TennisApiService
) : SearchRepository {

    override suspend fun playerSearch(query: String): ResultState<List<SearchResultModel>> {
        val searchResponse = tennisApiService.search(query)
        return withContext(Dispatchers.IO) {
            ResultState.Success(searchResponse.body()?.results!!.map { searchResult ->
                searchResult.toEntity()
            }
            )
        }
    }

}