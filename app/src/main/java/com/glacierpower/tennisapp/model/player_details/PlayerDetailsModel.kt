
package com.glacierpower.tennisapp.model.player_details

import com.glacierpower.tennisapp.model.eventModel.CategoryModel
import com.glacierpower.tennisapp.model.eventModel.TournamentModel
import model.ColorModel
import model.CountryModel
import model.SportModel

data class PlayerDetailsModel(
    val category: CategoryModel?,
    val country: CountryModel?,
    val disabled: Boolean,
    val fullName: String?,
    val gender: String?,
    val id: Int,
    val name: String?,
    val nameCode: String?,
    val national: Boolean,
    val playerTeamInfo: PlayerTeamInfoDetailsModel?,
    val ranking: Int,
    val shortName: String?,
    val slug: String?,
    val sport: SportModel?,
    val teamColor: ColorModel?,
    val tournament: TournamentModel?,
    val type: Int,
    val userCount: Int
)
