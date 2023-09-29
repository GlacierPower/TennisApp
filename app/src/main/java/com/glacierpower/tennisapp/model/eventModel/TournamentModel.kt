package com.glacierpower.tennisapp.model.eventModel

import com.glacierpower.tennisapp.data.service.responce.Events.Category
import com.glacierpower.tennisapp.data.service.responce.Events.UniqueTournament

data class TournamentModel(
    val category: CategoryModel?,
    val id:Int,
    val name:String,
    val priority:Int,
    val slug:String,
    val uniqueTournament: UniqueTournamentModel
)
