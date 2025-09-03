package theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class TennisElevation(
    val noElevation: Dp = 0.0.dp,
    val extraSmallElevation: Dp = 1.0.dp,
    val smallElevation: Dp = 3.0.dp,
    val mediumElevation: Dp = 6.0.dp,
    val largeElevation: Dp = 8.0.dp,
    val extraLarge: Dp = 12.0.dp
)

internal val LocalElevation = staticCompositionLocalOf { TennisElevation() }
