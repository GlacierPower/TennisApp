package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

@Composable
fun TennisTheme(
    typography: TennisTypography = TennisTheme.typography,
    shapes: TennisShapes = TennisTheme.shapes,
    dimensions: TennisDimensions = TennisTheme.dimensions,
    elevation: TennisElevation = TennisTheme.elevation,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (isDarkTheme) TennisDarkColor else TennisLightColors
    val rememberColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }

    CompositionLocalProvider(
        LocalColors provides rememberColors,
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalDimensions provides dimensions,
        LocalElevation provides elevation
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}

data object TennisTheme {

    val colors: TennisColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: TennisTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: TennisDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val shapes: TennisShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val elevation: TennisElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalElevation.current
}
