package com.glacirepower.tennisapp.match_details.mvi

import androidx.compose.runtime.Immutable
import com.glacirepower.tennisapp.match_details.model.TotalScoreDvo
import kotlinx.serialization.InternalSerializationApi
import model.events.PlayerEventsDataModel
import model.player_summaries.SummariesModel
import mvi.Reducer

@InternalSerializationApi
@Immutable
data class MatchDetailsState(
    val isLoading: Boolean = true,
    val summariesModel: SummariesModel? = null,
    val event: PlayerEventsDataModel?,
    val scoreDvo: TotalScoreDvo? = null
) : Reducer.ViewState {
    companion object {
        fun init(event: PlayerEventsDataModel?): MatchDetailsState {
            return MatchDetailsState(
                event = event
            )
        }
    }
}
