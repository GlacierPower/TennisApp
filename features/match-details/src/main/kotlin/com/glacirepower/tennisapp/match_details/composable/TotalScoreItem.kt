package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.match_details.R
import com.glacirepower.tennisapp.match_details.model.TotalScoreDvo
import theme.TennisTheme

@Composable
fun TotalScore(
    scoreDvo: TotalScoreDvo
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = TennisTheme.dimensions.padding.l),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        scoreDvo.apply {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.base.nameSpace),
            ) {
                TennisAppText(
                    text = homeTeamName,
                    style = TennisTheme.typography.body3
                )
                TennisAppText(
                    text = awayTeamName,
                    style = TennisTheme.typography.body3
                )
            }
            ScoreItem(
                set = stringResource(R.string.match_details_set),
                homeScore = setHome.orEmpty(),
                awayScore = setAway.orEmpty(),
                setTime = matchTime.orEmpty()
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            ScoreItem(
                set = stringResource(R.string.match_details_first_set),
                homeScore = firstSetHome,
                awayScore = firstSetAway,
                setTime = firstSetTime,
                homeTieBreak = firstSetTieHomeBreak.orEmpty(),
                awayTieBreak = firstSetTieAwayBreak.orEmpty()
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            ScoreItem(
                set = stringResource(R.string.match_details_second_set),
                homeScore = secondSetHome,
                awayScore = secondSetAway,
                setTime = secondSetTime,
                homeTieBreak = secondSetTieHomeBreak.orEmpty(),
                awayTieBreak = secondSetTieAwayBreak.orEmpty()
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            ScoreItem(
                set = stringResource(R.string.match_details_third_set),
                homeScore = thirdSetHome.orEmpty(),
                awayScore = thirdSetAway.orEmpty(),
                setTime = thirdSetTime,
                homeTieBreak = thirdSetTieHomeBreak.orEmpty(),
                awayTieBreak = thirdSetTieAwayBreak.orEmpty()
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            ScoreItem(
                set = stringResource(R.string.match_details_fourth_set),
                homeScore = fourthSetHome.orEmpty(),
                awayScore = fourthSetAway.orEmpty(),
                setTime = fourthSetTime,
                homeTieBreak = fourthSetTieHomeBreak.orEmpty(),
                awayTieBreak = fourthSetTieAwayBreak.orEmpty()
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            ScoreItem(
                set = stringResource(R.string.match_details_fifth_set),
                homeScore = fifthSetHome.orEmpty(),
                awayScore = fifthSetAway.orEmpty(),
                setTime = fifthSetTime,
                homeTieBreak = fifthSetTieHomeBreak.orEmpty(),
                awayTieBreak = fifthSetTieAwayBreak.orEmpty()
            )
        }
    }
}
