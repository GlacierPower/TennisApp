package com.glacierpower.tennisapp.data.service.responce.Events

data class Score(
    val current:Int,
    val display:Int,
    val period1:Int,
//    val period1TieBreak:Int?,
    val period2:Int?,
//    val period2TieBreak:Int?,
    val period3:Int?,
//    val period3TieBreak:Int?,
    val period4:Int?,
//    val period4TieBreak:Int?,
    val period5:Int?,
//    val period5TieBreak:Int?,
    val point:String?
)
