package com.glacirepower.tennisapp.match_details.mvi

import com.glacirepower.tennisapp.match_details.mappers.toEventDvo
import com.glacirepower.tennisapp.match_details.mappers.toScoreDvo
import com.glacirepower.tennisapp.match_details.mappers.toServeDvo
import com.glacirepower.tennisapp.match_details.mappers.toStatisticDvo
import com.glacirepower.tennisapp.match_details.model.ServeDvo
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticModel
import kotlinx.serialization.InternalSerializationApi
import mvi.Reducer
import javax.inject.Inject

@InternalSerializationApi
class MatchDetailsReducer @Inject constructor() :
    Reducer<MatchDetailsState, MatchDetailsEvent, MatchDetailsEffect> {
    override fun reduce(
        previousState: MatchDetailsState,
        event: MatchDetailsEvent
    ): Pair<MatchDetailsState, MatchDetailsEffect?> {
        return when (event) {
            MatchDetailsEvent.OnNavigateBack -> previousState to MatchDetailsEffect.NavigateBack
            is MatchDetailsEvent.OnEventDetailsLoaded -> {
                previousState.copy(
                    scoreDvo = previousState.event?.toScoreDvo(),
                    eventDvo = previousState.event?.toEventDvo(),
                    isLoading = false
                ) to null
            }

            is MatchDetailsEvent.OnPointByPointLoaded -> {
                val filteredPointByPoint = filterPointByPointBySet(
                    pointByPoint = event.pointByPoint.flatMap { it.type.toServeDvo() },
                    selectedSet = previousState.set
                )

                previousState.copy(
                    serveDvo = filteredPointByPoint,
                    originalServeDvo = event.pointByPoint.flatMap { it.type.toServeDvo() },
                    sets = event.pointByPoint.flatMap { it.type },
                    isLoading = false
                ) to null
            }

            is MatchDetailsEvent.OnUpdateSet -> {
                val filteredPointByPoint = filterPointByPointBySet(
                    pointByPoint = previousState.originalServeDvo,
                    selectedSet = event.set
                )

                previousState.copy(
                    set = event.set,
                    serveDvo = filteredPointByPoint
                ) to null
            }

            is MatchDetailsEvent.OnStatisticsLoaded -> {
                previousState.copy(
                    statistics = event.statistics.data.toFilteredStatistics(
                        selectedPeriod = "all"
                    ).toStatisticDvo(),
                    setStatistic = event.statistics.data.map { it.period }
                        .distinct()
                ) to null
            }
        }
    }

    private fun filterPointByPointBySet(
        pointByPoint: List<ServeDvo>,
        selectedSet: Int
    ): List<ServeDvo> {
        return pointByPoint.filter { it.set == selectedSet }
    }

    private fun List<StatisticModel>.toFilteredStatistics(
        selectedPeriod: String
    ): List<StatisticModel> {
        return this.filter { it.period == selectedPeriod }
    }
}
