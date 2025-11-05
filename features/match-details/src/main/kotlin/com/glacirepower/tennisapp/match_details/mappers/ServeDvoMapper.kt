package com.glacirepower.tennisapp.match_details.mappers

import com.glacirepower.tennisapp.match_details.model.ServeDvo
import com.glacirepower.tennisapp.match_details.model.SetDataModel

fun List<SetDataModel>.toServeDvo(): List<ServeDvo> {
    val homeTeamId = 1
    val awayTeamId = 2
    return this.flatMap { set ->
        set.games.map { game ->
            ServeDvo(
                isHomeLostServe = game.score.scoring != homeTeamId,
                isAwayLostServe = game.score.serving != awayTeamId,
                isHomeServe = game.score.serving == homeTeamId,
                isAwayServe = game.score.serving == awayTeamId,
                homeScore = game.score.homeScore,
                awayScore = game.score.awayScore,
                points = game.points,
                set = set.set
            )
        }
    }
}
