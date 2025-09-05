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
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val space20: Dp = 20.dp,
    val space10: Dp = 10.dp
)

@ConsistentCopyVisibility
@Immutable
data class ButtonDimens internal constructor(
    val circularButtonSize: Dp = 40.dp
)

@ConsistentCopyVisibility
@Immutable
data class IconDimens internal constructor(
    val extraSmall: Dp = 16.dp,
    val small: Dp = 24.dp,
    val large: Dp = 32.dp
)

@ConsistentCopyVisibility
@Immutable
data class BaseDimmens internal constructor(
    val spaserLarge: Dp = 20.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { TennisDimensions() }
