package theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class TennisShapes(
    val small: RoundedCornerShape = RoundedCornerShape(size = 8.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(size = 16.dp),
    val large: RoundedCornerShape = RoundedCornerShape(size = 24.dp)
)

internal val LocalShapes = staticCompositionLocalOf { TennisShapes() }
