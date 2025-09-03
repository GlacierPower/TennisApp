package theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.glacierpower.tennisapp.core.ui.R

val TennisFontFamily = FontFamily(
    Font(R.font.lato_black),
    Font(R.font.lato_blackitalic),
    Font(R.font.lato_bold),
    Font(R.font.lato_bolditalic),
    Font(R.font.lato_italic),
    Font(R.font.lato_light),
    Font(R.font.lato_lightitalic),
    Font(R.font.lato_regular),
    Font(R.font.lato_thin),
    Font(R.font.lato_thinitalic)
)

@Immutable
data class TennisTypography(

    val displayLarge: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),

    val headlineLarge: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),

    val title1: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    val title2: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    val title3: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),

    val body1: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    val body1Bold: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    val body2Bold: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    val body3: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),

    val labelLarge: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    val labelMedium: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    val labelSmall: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),

    val caption: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    val captionBold: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),

    val overline: TextStyle = TextStyle(
        fontFamily = TennisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.5.sp,
    )
)

internal val LocalTypography = staticCompositionLocalOf { TennisTypography() }
