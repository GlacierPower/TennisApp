package com.glacierpower.tennisapp.data.data_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "rankingEntity")
data class AtpRankingEntity(
    val bestRanking: Int,
    val bestRankingDateTimestamp: Int,
    val country: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val points: Int,
    val previousPoints: Int,
    val previousRanking: Int,
    val ranking: Int,
    val rankingClass: String,
    val rowName: String,
//    val team: EntityTeam,
    val tournamentsPlayed: Int,
    val type: Int
) : Serializable

data class EntityTeam(
    val country: EntityCountry,
    val disabled: Boolean,
    val gender: String,
    val id: Int,
    val name: String,
    val nameCode: String,
    val national: Boolean,
    val ranking: Int,
    val shortName: String,
    val slug: String,
    val sport: SportEntity,
    val teamColors: TeamColorEntity,
    val type: Int,
    val userCount: Int
) : Serializable


data class TeamColorEntity(
    val primary: String,
    val secondary: String,
    val text: String
) : Serializable

data class SportEntity(
    val id: Int,
    val name: String,
    val slug: String
) : Serializable

data class EntityCountry(
    val alpha2: String,
    val name: String
) : Serializable
