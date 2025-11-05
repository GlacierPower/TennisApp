package com.glacierpower.tennisapp.data.tournament_details.mappers

import api.responce.tournament_details.TournamentRs
import com.glacierpower.tennisapp.domain.tournament_details.model.TournamentModel
import mappers.toMetaModel

fun TournamentRs.toTournamentModel(): TournamentModel {
    return TournamentModel(
        data = data.toMatchModel(),
        meta = meta.toMetaModel()
    )
}
