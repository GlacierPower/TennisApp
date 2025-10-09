package com.glacierpower.tennisapp.domain.tournament_details.model

import model.events.MetaModel

data class TournamentModel(
    val data: List<MatchModel>,
    val meta: MetaModel
)
