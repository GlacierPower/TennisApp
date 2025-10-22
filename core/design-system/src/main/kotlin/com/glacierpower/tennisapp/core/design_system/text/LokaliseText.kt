package com.glacierpower.tennisapp.core.design_system.text

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.glacierpower.tennisapp.core.design_system.util.lokaliseKeyFromRes
import com.lokalise.sdk.LokaliseResources
import theme.TennisTheme

@Composable
fun LokaliseText(
    @StringRes stringRes: Int,
    modifier: Modifier = Modifier,
    color: Color = TennisTheme.colors.textPrimary,
    style: TextStyle = TennisTheme.typography.body1,
    minLines: Int = 1,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
) {
    val context = LocalContext.current
    val lokalise = remember {
        LokaliseResources(context)
    }
    val (lokaliseKey, fallbackText) = remember(stringRes) {
        val key = lokaliseKeyFromRes(context, stringRes)
        val fallback = context.getString(stringRes)
        key to fallback
    }

    val text = remember(lokaliseKey) {
        lokalise.getString(lokaliseKey = lokaliseKey) ?: fallbackText
    }
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style
    )
}
