package com.glacierpower.tennisapp.data.service.responce.player_near_events

import com.glacierpower.tennisapp.data.service.responce.live_event.*
import com.google.gson.annotations.SerializedName

data class NextEvent(
    @SerializedName("awayScore")
    val awayScore:Score?,
    @SerializedName("awayTeam")
    val awayTeam:Team,
    @SerializedName("changes")
    val changes:Changes,
    @SerializedName("crowdsourcingDataDisplayEnabled")
    val crowdsourcingDataDisplayEnabled:Boolean,
    @SerializedName("customId")
    val customId:String,
    @SerializedName("finalResultOnly")
    val finalResultOnly:Boolean,
    @SerializedName("groundType")
    val groundType:String,
    @SerializedName("hasGlobalHighlights")
    val hasGlobalHighlights:Boolean,
    @SerializedName("homeScore")
    val homeScore:Score?,
    @SerializedName("homeTeam")
    val homeTeam:Team,
    @SerializedName("homeTeamSeed")
    val homeTeamSeed:String?,
    @SerializedName("id")
    val id:Int,
    @SerializedName("periods")
    val periods:Periods,
    @SerializedName("roundInfo")
    val roundInfo:RoundInfo,
    @SerializedName("slug")
    val slug:String,
    @SerializedName("startTimestamp")
    val startTimestamp:Long,
    @SerializedName("status")
    val status:Status,
    @SerializedName("time")
    val time:Time?,
    @SerializedName("tournament")
    val tournament:Tournament
)
