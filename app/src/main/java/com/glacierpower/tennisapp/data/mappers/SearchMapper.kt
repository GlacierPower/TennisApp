package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.SearchEntity
import com.glacierpower.tennisapp.data.service.responce.SearchResult
import com.glacierpower.tennisapp.model.resultModel.EntityModel
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel
import model.ColorModel
import model.CountryModel
import model.SportModel

fun SearchResult.toEntity(): SearchResultModel {
    return SearchResultModel(
        entity?.toEntity(),
        score,
        type
    )
}

fun SearchEntity.toEntity(): EntityModel? {
    return EntityModel(
        category?.toEntity(),
        CountryModel(
            alpha2 = this.country.alpha2,
            alpha3 = this.country.alpha3,
            name = this.country.name,
            slug = this.country.slug
        ),
        displayInverseHomeAwayTeams,
        disabled,
        gender,
        id,
        name,
        nameCode,
        national,
        ranking,
        shortName,
        slug,
        SportModel(
            name = this.sport?.name ?: "",
            slug = this.sport?.slug ?: "",
            id = this.sport?.id ?: 1
        ),
        ColorModel(
            primary = this.teamColor?.primary ?: "",
            secondary = this.teamColor?.secondary ?: "",
            text = this.teamColor?.text ?: ""
        ),
        type,
        userCount
    )
}