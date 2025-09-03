package com.glacierpower.tennisapp.core.design_system.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun TennisAppButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = TennisTheme.shapes.small,
    colors: ButtonColors = TennisButtonColors,
    elevation: ButtonElevation = TennisButtonElevation,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    onClick: () -> Unit,
    content: @Composable (RowScope) -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

private val TennisButtonColors: ButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors(
        contentColor = TennisTheme.colors.buttonTextLight,
        containerColor = TennisTheme.colors.buttonPrimary,
        disabledContentColor = TennisTheme.colors.buttonDisabled,
        disabledContainerColor = TennisTheme.colors.buttonDisabled
    )
private val TennisButtonElevation: ButtonElevation
    @Composable
    get() = ButtonDefaults.buttonElevation(
        defaultElevation = TennisTheme.elevation.noElevation,
        pressedElevation = TennisTheme.elevation.noElevation,
        focusedElevation = TennisTheme.elevation.noElevation,
        hoveredElevation = TennisTheme.elevation.extraSmallElevation,
        disabledElevation = TennisTheme.elevation.noElevation,
    )

@Composable
@Preview
fun PreviewTennisButton() {
    TennisTheme {
        TennisAppButton(
            onClick = {},
            content = {
                TennisAppText(
                    "Save"
                )
            }
        )
    }
}
