package mappers.events

import api.responce.player_events.PlayerEventsDataRs
import mappers.toSectionModel
import mappers.toSportModel
import model.events.PlayerEventsDataModel

fun List<PlayerEventsDataRs>.toPlayerEventsDataModel(): List<PlayerEventsDataModel> {
    return this.map { data ->
        PlayerEventsDataModel(
            id = data.id,
            sportId = data.sportId,
            homeTeamId = data.homeTeamId,
            awayTeamId = data.awayTeamId,
            leagueId = data.leagueId,
            challengeId = data.challengeId,
            seasonId = data.seasonId,
            venueId = data.venueId,
            refereeId = data.refereeId,
            slug = data.slug,
            name = data.name,
            status = data.status.replaceFirstChar { it.uppercase() },
            statusMore = data.statusMore,
            timeDetails = data.timeDetails?.toTimeDetailsModel(),
            homeTeam = data.homeTeam.toTeamModel(),
            awayTeam = data.awayTeam.toTeamModel(),
            startAt = data.startAt,
            priority = data.priority,
            homeScore = data.homeScore?.toScoreModel(),
            awayScore = data.awayScore?.toScoreModel(),
            winnerCode = data.winnerCode,
            aggregatedWinnerCode = data.aggregatedWinnerCode,
            resultOnly = data.resultOnly,
            coverage = data.coverage,
            groundType = data.groundType,
            roundNumber = data.roundNumber,
            seriesCount = data.seriesCount,
            mediasCount = data.mediasCount,
            statusLineUp = data.statusLineUp,
            firstSupply = data.firstSupply,
            cardsCode = data.cardsCode,
            eventDataChange = data.eventDataChange,
            lastedPeriod = data.lastedPeriod,
            defaultPeriodCount = data.defaultPeriodCount,
            attendance = data.attendance,
            cupMatchOrder = data.cupMatchOrder,
            cupMatchInRound = data.cupMatchInRound,
            periods = data.periods,
            roundInfo = data.roundInfo?.toRoundInfoModel(),
            periodsTime = data.periodsTime.map { it.toPeriodsTimeModel() },
            mainStat = data.mainStat?.toMainStatModel(),
            mainOdds = data.mainOdds?.toMainOddsModel(),
            league = data.league.toLeagueModel(),
            challenge = data.challenge.toChallengeModel(),
            season = data.season.toSeasonModel(),
            section = data.section.toSectionModel(),
            sport = data.sport.toSportModel(),
        )
    }
}
