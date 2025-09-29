package com.glacierpower.tennisapp.domain.ranking.model

import model.common.NameTranslationsModel

data class TeamModel(
    val id: Int,
    val sportId: Int,
    val categoryId: Int?,
    val venueId: Int?,
    val managerId: Int?,
    val slug: String,
    val name: String,
    val hasLogo: Boolean,
    val logo: String,
    val nameTranslationsRs: NameTranslationsModel,
    val nameShort: String,
    val nameFull: String,
    val nameCode: String,
    val hasSub: Boolean,
    val gender: String,
    val isNationality: Boolean,
    val countryCode: String,
    val country: String,
    val flag: String,
    val foundation: String?
)
