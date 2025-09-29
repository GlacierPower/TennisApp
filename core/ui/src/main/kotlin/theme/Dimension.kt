package theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ConsistentCopyVisibility
@Immutable
data class TennisDimensions internal constructor(
    val padding: PaddingDimmens = PaddingDimmens(),
    val button: ButtonDimens = ButtonDimens(),
    val base: BaseDimmens = BaseDimmens(),
    val space: SpaceDimmens = SpaceDimmens(),
    val icon: IconDimens = IconDimens()
)

@ConsistentCopyVisibility
@Immutable
data class PaddingDimmens internal constructor(
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    val s: Dp = 8.dp,
    val m: Dp = 16.dp,
    val l: Dp = 24.dp,
    val xl: Dp = 32.dp,
)

@ConsistentCopyVisibility
@Immutable
data class SpaceDimmens internal constructor(
    val xxs: Dp = 4.dp,
    val s: Dp = 8.dp,
    val m: Dp = 16.dp,
    val l: Dp = 24.dp,
    val xxl: Dp = 32.dp,
    val xxxl: Dp = 80.dp
)

@ConsistentCopyVisibility
@Immutable
data class ButtonDimens internal constructor(
    val circularButtonSize: Dp = 40.dp
)

@ConsistentCopyVisibility
@Immutable
data class IconDimens internal constructor(
    val xss: Dp = 8.dp,
    val s: Dp = 16.dp,
    val l: Dp = 24.dp,
    val m: Dp = 32.dp,
    val xxl: Dp = 48.dp
)

@ConsistentCopyVisibility
@Immutable
data class BaseDimmens internal constructor(
    val nameSpace: Dp = 12.dp,
    val pagerIndicatorHeight: Dp = 8.dp,
    val spaserLarge: Dp = 20.dp,
    val bottomBarHeight: Dp = 120.dp
)

internal val LocalDimensions = staticCompositionLocalOf { TennisDimensions() }
