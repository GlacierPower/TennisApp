package com.glacierpower.tennisapp.features.player_profile.model

import kotlinx.serialization.Serializable

@Serializable
enum class MatchStatus {
    ENDED,
    WALKOVER,
    RETIRED,
    NOT_STARTED;

    companion object {
        fun fromString(value: String?): MatchStatus {
            return when (value?.uppercase()) {
                "NOT STARTED" -> NOT_STARTED
                "ENDED" -> ENDED
                "WALKOVER" -> WALKOVER
                "RETIRED" -> RETIRED
                else -> ENDED
            }
        }
    }
}
