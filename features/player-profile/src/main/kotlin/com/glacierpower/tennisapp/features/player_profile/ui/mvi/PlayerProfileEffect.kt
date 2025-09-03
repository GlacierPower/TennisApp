package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import mvi.Reducer

sealed interface PlayerProfileEffect : Reducer.ViewEffect {
    data object NavigateBack : PlayerProfileEffect
}
