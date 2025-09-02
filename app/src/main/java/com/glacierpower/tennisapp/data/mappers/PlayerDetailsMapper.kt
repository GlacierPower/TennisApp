
package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.player_details.PlayerDetailsResponse
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import model.ColorModel
import model.CountryModel
import model.SportModel

fun PlayerDetailsResponse.toEntity(): PlayerDetailsModel {
    return PlayerDetailsModel(
        category?.toEntity(),
        CountryModel(
            alpha2 = this.country?.alpha2 ?: "",
            alpha3 = this.country?.alpha3 ?: "",
            name = this.country?.name ?: "",
            slug = this.country?.slug ?: ""
        ),
        disabled,
        fullName,
        gender,
        id,
        name,
        nameCode,
        national,
        playerTeamInfoDetails?.toEntity(),
        ranking,
        shortName,
        slug,
        SportModel(
            id = this.sport?.id ?: 1,
            name = this.sport?.name ?: "",
            slug = this.sport?.slug ?: ""
        ),
        ColorModel(
            primary = this.teamColor?.primary ?: "",
            secondary = this.teamColor?.secondary ?: "",
            text = this.teamColor?.text ?: ""
        ),
        tournament?.toEntity(),
        type,
        userCount

    )
}
