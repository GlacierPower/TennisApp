package com.glacierpower.tennisapp.data.repositoryImpl

import android.util.Log
import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.search.SearchRepository
import com.glacierpower.tennisapp.model.resultModel.EntityModel
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel
import com.glacierpower.tennisapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class SearchRepositoryImpl @Inject constructor(
    @Named("Tennis")private val tennisApiService: TennisApiService
) : SearchRepository {

    override suspend fun playerSearch(query: String): ResultState<List<SearchResultModel>> {
        val searchResponse = tennisApiService.search(query)
        return withContext(Dispatchers.IO) {
            ResultState.Success(searchResponse.body()?.results!!.map {searchResult->
                searchResult.toEntity()
            }
            )
        }
    }


}