package com.glacierpower.tennisapp.model.eventModel

data class ScoreModel(
    val current:Int,
    val display:Int,
    val period1:Int,
    val period2:Int?,
    val period3:Int?,
    val period4:Int?,
    val period5:Int?,
    val point:String?
)
