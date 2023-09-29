package com.glacierpower.tennisapp.data.service.responce.Events

data class Tournament(
    val category:Category?,
    val id:Int,
    val name:String,
    val priority:Int,
    val slug:String,
    val uniqueTournament:UniqueTournament
)
