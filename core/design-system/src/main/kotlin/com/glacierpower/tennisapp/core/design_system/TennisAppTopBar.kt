package com.glacierpower.tennisapp.core.design_system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.buttons.TennisAppCircularButton
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun TennisAppTopBar(
    modifier: Modifier = Modifier,
    title: Int? = null,
    leftIcon: Int? = null,
    rightIcon: Int? = null,
    onLeftIconClick: (() -> Unit)? = null,
    onRightIconClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .background(TennisTheme.colors.backgroundGlobe)
            .padding(vertical = TennisTheme.dimensions.padding.l),
        verticalAlignment = Alignment.CenterVertically
    ) {
        leftIcon?.let {
            TennisAppCircularButton(
                iconId = leftIcon,
                onClick = { onLeftIconClick?.invoke() }
            )
        }

        TennisAppSpacer(size = TennisTheme.dimensions.padding.l)

        title?.let {
            TennisAppText(
                text = stringResource(title),
                style = TennisTheme.typography.title1,
                modifier = Modifier.weight(1f)
            )
        }

        rightIcon?.let {
            TennisAppCircularButton(
                iconId = rightIcon,
                onClick = { onRightIconClick?.invoke() }
            )
        }
    }
}
