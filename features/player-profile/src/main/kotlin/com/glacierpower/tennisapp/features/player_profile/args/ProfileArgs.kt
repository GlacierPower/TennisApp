package com.glacierpower.tennisapp.features.player_profile.args

import kotlinx.serialization.Serializable

@Serializable
data class ProfileArgs(
    val rank: String? = null,
    val id: String? = null
)
