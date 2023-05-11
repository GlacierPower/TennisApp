package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.SearchEntity
import com.glacierpower.tennisapp.data.service.responce.SearchResult
import com.glacierpower.tennisapp.model.resultModel.EntityModel
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel

fun SearchResult.toEntity(): SearchResultModel {
    return SearchResultModel(
        searchEntity.toEntity(),
        score,
        type
    )
}

fun SearchEntity.toEntity(): EntityModel {
    return EntityModel(
        country.toEntity(),
        gender,
        id,
        name,
        nameCode,
        national,
        ranking,
        shortName,
        slug,
        sport.toEntity(),
        teamColor.toEntity(),
        type,
        userCount
    )
}