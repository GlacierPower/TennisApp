package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.player_profile.R
import com.glacierpower.tennisapp.features.player_profile.model.MatchStatus
import theme.TennisTheme

@Composable
internal fun StatusIcon(
    matchStatus: MatchStatus,
    isWin: Boolean
) {
    val (color, label) = when {
        matchStatus.name == MatchStatus.NOT_STARTED.name ->
            TennisTheme.colors.textSecondary to stringResource(R.string.player_profile_match_not_started)
        isWin ->
            TennisTheme.colors.textAccentSecondary to stringResource(R.string.player_profile_match_won)
        else ->
            TennisTheme.colors.statusDanger to stringResource(R.string.player_profile_match_lost)
    }
    Box(
        modifier = Modifier
            .background(color = color, shape = TennisTheme.shapes.small)
            .size(TennisTheme.dimensions.icon.l),
        contentAlignment = Alignment.Center
    ) {
        TennisAppText(
            text = label,
            color = TennisTheme.colors.iconPrimaryInverseLight,
            style = TennisTheme.typography.body3
        )
    }
}
