package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.event_details.*
import com.glacierpower.tennisapp.data.service.responce.live_event.Status
import com.glacierpower.tennisapp.model.eventDetailsModel.*

fun EventDetails.toEntity(): EventDetailsModel {
    return EventDetailsModel(
        awayScore.toEntity(),
        awayTeam.toEntity(),
        awayTeamSeed,
        bet365ExcludedCountryCodes,
        changes.toEntity(),
        crowdsourcingEnabled,
        crowdsourcingEnabled,
        currentPeriodStartTimestamp,
        customId,
        defaultPeriodCount,
        endTimestamp,
        fanRatingEvent,
        finalResultOnly,
        firstToServe,
        groundType,
        hasGlobalHighlights,
        hasGlobalHighlights,
        homeScore.toEntity(),
        homeTeam.toEntity(),
        homeTeamSeed,
        id,
        lastPeriod,
        periods.toEntity(),
        roundInfo?.toEntity(),
        season.toEntity(),
        showTotoPromo,
        slug,
        startTimestamp,
        status.toEntity(),
        time.toEntity(),
        tournament.toEntity(),
        venue?.toEntity(),
        winnerCode
    )

}

fun Season.toEntity(): SeasonModel {
    return SeasonModel(
        editor, id, name, year
    )
}

fun Status.toEntity(): StatusModel {
    return StatusModel(
        code, description, type
    )
}

fun Venue.toEntity(): VenueModel {
    return VenueModel(
        city.toEntity(),
        country.toEntity(),
        id,
        stadium.toEntity()
    )
}

fun City.toEntity(): CityModel {
    return CityModel(
        name
    )
}

fun Stadium.toEntity(): StadiumModel {
    return StadiumModel(
        name
    )
}