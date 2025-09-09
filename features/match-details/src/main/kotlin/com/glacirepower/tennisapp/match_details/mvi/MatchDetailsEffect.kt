package com.glacirepower.tennisapp.match_details.mvi

import mvi.Reducer

interface MatchDetailsEffect : Reducer.ViewEffect {
    data object NavigateBack : MatchDetailsEffect
}
