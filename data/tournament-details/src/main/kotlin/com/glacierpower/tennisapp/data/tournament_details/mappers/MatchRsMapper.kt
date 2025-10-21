package com.glacierpower.tennisapp.data.tournament_details.mappers

import api.responce.tournament_details.MatchRs
import com.glacierpower.tennisapp.domain.tournament_details.model.MatchModel
import mappers.toChallengeModel
import mappers.toLeagueModel
import mappers.toMainOddsModel
import mappers.toPeriodsModel
import mappers.toPeriodsTimeModel
import mappers.toRoundInfoModel
import mappers.toScoreModel
import mappers.toSeasonModel
import mappers.toSectionModel
import mappers.toSportModel
import mappers.toTeamModel
import mappers.toTimeDetailsModel

fun List<MatchRs>.toMatchModel(): List<MatchModel> {
    return this.map { match ->
        MatchModel(
            id = match.id,
            sportId = match.sportId,
            homeTeamId = match.homeTeamId,
            awayTeamId = match.awayTeamId,
            leagueId = match.leagueId,
            challengeId = match.challengeId,
            seasonId = match.seasonId,
            venueId = match.venueId,
            refereeId = match.refereeId,
            slug = match.slug,
            name = match.name,
            status = match.status,
            statusMore = match.statusMore,
            timeDetails = match.timeDetails?.toTimeDetailsModel(),
            homeTeam = match.homeTeam.toTeamModel(),
            awayTeam = match.awayTeam.toTeamModel(),
            startAt = match.startAt,
            priority = match.priority,
            homeScore = match.homeScore?.toScoreModel(),
            awayScore = match.awayScore?.toScoreModel(),
            winnerCode = match.winnerCode,
            aggregatedWinnerCode = match.aggregatedWinnerCode,
            resultOnly = match.resultOnly,
            coverage = match.coverage,
            groundType = match.groundType,
            roundNumber = match.roundNumber,
            seriesCount = match.seriesCount,
            mediasCount = match.mediasCount,
            statusLineup = match.statusLineup,
            firstSupply = match.firstSupply,
            cardsCode = match.cardsCode,
            eventDataChange = match.eventDataChange,
            lastedPeriod = match.lastedPeriod,
            defaultPeriodCount = match.defaultPeriodCount,
            attendance = match.attendance,
            cupMatchOrder = match.cupMatchOrder,
            cupMatchInRound = match.cupMatchInRound,
            periods = match.periods?.toPeriodsModel(),
            roundInfo = match.roundInfo?.toRoundInfoModel(),
            periodsTime = match.periodsTime.toPeriodsTimeModel(),
            mainOdds = match.mainOdds?.toMainOddsModel(),
            league = match.league?.toLeagueModel(),
            challenge = match.challenge?.toChallengeModel(),
            season = match.season?.toSeasonModel(),
            section = match.section?.toSectionModel(),
            sport = match.sport?.toSportModel()
        )
    }
}
