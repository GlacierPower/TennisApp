package com.glacirepower.tennisapp.match_details.mvi

import androidx.compose.runtime.Immutable
import com.glacirepower.tennisapp.match_details.model.EventDvo
import com.glacirepower.tennisapp.match_details.model.ServeDvo
import com.glacirepower.tennisapp.match_details.model.SetDataModel
import com.glacirepower.tennisapp.match_details.model.TotalScoreDvo
import kotlinx.serialization.InternalSerializationApi
import model.events.PlayerEventsDataModel
import mvi.Reducer

@InternalSerializationApi
@Immutable
data class MatchDetailsState(
    val isLoading: Boolean = true,
    val event: PlayerEventsDataModel?,
    val scoreDvo: TotalScoreDvo? = null,
    val eventDvo: EventDvo? = null,
    val sets: List<SetDataModel> = emptyList(),
    val set: Int = 1,
    val isSelected: Boolean = true,
    val serveDvo: List<ServeDvo> = emptyList(),
    val originalServeDvo: List<ServeDvo> = emptyList()
) : Reducer.ViewState {
    companion object {
        fun init(event: PlayerEventsDataModel?): MatchDetailsState {
            return MatchDetailsState(
                event = event
            )
        }
    }
}
