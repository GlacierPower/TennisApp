package theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class TennisShapes(
    val xss: RoundedCornerShape = RoundedCornerShape(2.dp),
    val xs: RoundedCornerShape = RoundedCornerShape(4.dp),
    val s: RoundedCornerShape = RoundedCornerShape(size = 8.dp),
    val m: RoundedCornerShape = RoundedCornerShape(size = 16.dp),
    val l: RoundedCornerShape = RoundedCornerShape(size = 24.dp),
    val circularButton: CornerBasedShape = RoundedCornerShape(30.dp),
    val pagerIndicator: RoundedCornerShape = RoundedCornerShape(
        topStart = 4.dp,
        topEnd = 4.dp
    )
)

internal val LocalShapes = staticCompositionLocalOf { TennisShapes() }
