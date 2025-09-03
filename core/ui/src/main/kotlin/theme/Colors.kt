package theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val TennisDarkColor = TennisColors(
    backgroundGlobe = Color(0xFF1C1B20),
    backgroundIsland = Color(0xFF24232A),
    backgroundOnIsland = Color(0xFF313038),
    backgroundOnIslandHover = Color(0xFF3B3A42),
    backgroundColoured = Color(0xFF775CDF),
    dividerLight = Color(0xFF303030),
    dividerDark = Color(0xFF24232A),
    overlayLight = Color(0x66000000),
    overlayDark = Color(0x99000000),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFFE2E2E2),
    textTertiary = Color(0xFF9F9F9F),
    textPrimaryInverseLight = Color(0xFFFFFFFF),
    textPrimaryInverseDark = Color(0xFF1C1B20),
    textAccentPrimary = Color(0xFFB19CFF),
    textAccentSecondary = Color(0xFFB5DB1C),
    iconPrimary = Color(0xFFFFFFFF),
    iconSecondary = Color(0xFFE2E2E2),
    iconTertiary = Color(0xFF9F9F9F),
    iconPrimaryInverseLight = Color(0xFFFFFFFF),
    iconPrimaryInverseDark = Color(0xFF1C1B20),
    iconAccentPrimary = Color(0xFF775CDF),
    iconAccentSecondary = Color(0xFFB5DB1C),
    statusDanger = Color(0xFFEB3333),
    statusSuccess = Color(0xFF1CDB2F),
    statusWarning = Color(0xFFF5CB3E),
    buttonPrimary = Color(0xFF775CDF),
    buttonPrimaryOnTap = Color(0xFF6247CF),
    buttonSecondary = Color(0xFFB5DB1C),
    buttonSecondaryOnTap = Color(0xFF7E9E00),
    buttonTertiary = Color(0xFF313038),
    buttonTertiaryOnTap = Color(0xFF3B3A42),
    buttonDisabled = Color(0xFF312F37),
    buttonTextDark = Color(0xFF1C1B20),
    buttonTextLight = Color(0xFFFFFFFF)
)

val TennisLightColors = TennisColors(
    backgroundGlobe = Color(0xFFF5F5F7),
    backgroundIsland = Color(0xFFFFFFFF),
    backgroundOnIsland = Color(0xFFF5F5F7),
    backgroundOnIslandHover = Color(0xFFEBEBED),
    backgroundColoured = Color(0xFF775CDF),
    dividerLight = Color(0xFFEBEBED),
    dividerDark = Color(0xFFD1D1D6),
    overlayLight = Color(0x33FFFFFF),
    overlayDark = Color(0x66FFFFFF),
    textPrimary = Color(0xFF1C1B20),
    textSecondary = Color(0xFF42424A),
    textTertiary = Color(0xFF6E6E78),
    textPrimaryInverseLight = Color(0xFFFFFFFF),
    textPrimaryInverseDark = Color(0xFF1C1B20),
    textAccentPrimary = Color(0xFF6247CF),
    textAccentSecondary = Color(0xFF7E9E00),
    iconPrimary = Color(0xFF1C1B20),
    iconSecondary = Color(0xFF42424A),
    iconTertiary = Color(0xFF6E6E78),
    iconPrimaryInverseLight = Color(0xFFFFFFFF),
    iconPrimaryInverseDark = Color(0xFF1C1B20),
    iconAccentPrimary = Color(0xFF775CDF),
    iconAccentSecondary = Color(0xFFB5DB1C),
    statusDanger = Color(0xFFD32F2F),
    statusSuccess = Color(0xFF2E7D32),
    statusWarning = Color(0xFFF9A825),
    buttonPrimary = Color(0xFF775CDF),
    buttonPrimaryOnTap = Color(0xFF6247CF),
    buttonSecondary = Color(0xFFB5DB1C),
    buttonSecondaryOnTap = Color(0xFF7E9E00),
    buttonTertiary = Color(0xFFF5F5F7),
    buttonTertiaryOnTap = Color(0xFFEBEBED),
    buttonDisabled = Color(0xFFF5F5F7),
    buttonTextDark = Color(0xFF1C1B20),
    buttonTextLight = Color(0xFFFFFFFF),
)

@Immutable
class TennisColors(
    backgroundGlobe: Color,
    backgroundIsland: Color,
    backgroundOnIsland: Color,
    backgroundOnIslandHover: Color,
    backgroundColoured: Color,
    dividerLight: Color,
    dividerDark: Color,
    overlayLight: Color,
    overlayDark: Color,
    textPrimary: Color,
    textSecondary: Color,
    textTertiary: Color,
    textPrimaryInverseLight: Color,
    textPrimaryInverseDark: Color,
    textAccentPrimary: Color,
    textAccentSecondary: Color,
    iconPrimary: Color,
    iconSecondary: Color,
    iconTertiary: Color,
    iconPrimaryInverseLight: Color,
    iconPrimaryInverseDark: Color,
    iconAccentPrimary: Color,
    iconAccentSecondary: Color,
    statusDanger: Color,
    statusSuccess: Color,
    statusWarning: Color,
    buttonPrimary: Color,
    buttonPrimaryOnTap: Color,
    buttonSecondary: Color,
    buttonSecondaryOnTap: Color,
    buttonTertiary: Color,
    buttonTertiaryOnTap: Color,
    buttonDisabled: Color,
    buttonTextDark: Color,
    buttonTextLight: Color
) {
    var backgroundGlobe by mutableStateOf(backgroundGlobe)
        private set
    var backgroundIsland by mutableStateOf(backgroundIsland)
        private set
    var backgroundOnIsland by mutableStateOf(backgroundOnIsland)
        private set
    var backgroundOnIslandHover by mutableStateOf(backgroundOnIslandHover)
        private set
    var backgroundColoured by mutableStateOf(backgroundColoured)
        private set
    var dividerLight by mutableStateOf(dividerLight)
        private set
    var dividerDark by mutableStateOf(dividerDark)
        private set
    var overlayLight by mutableStateOf(overlayLight)
        private set
    var overlayDark by mutableStateOf(overlayDark)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textTertiary by mutableStateOf(textTertiary)
        private set
    var textPrimaryInverseLight by mutableStateOf(textPrimaryInverseLight)
        private set
    var textPrimaryInverseDark by mutableStateOf(textPrimaryInverseDark)
        private set
    var textAccentPrimary by mutableStateOf(textAccentPrimary)
        private set
    var textAccentSecondary by mutableStateOf(textAccentSecondary)
        private set
    var iconPrimary by mutableStateOf(iconPrimary)
        private set
    var iconSecondary by mutableStateOf(iconSecondary)
        private set
    var iconTertiary by mutableStateOf(iconTertiary)
        private set
    var iconPrimaryInverseLight by mutableStateOf(iconPrimaryInverseLight)
        private set
    var iconPrimaryInverseDark by mutableStateOf(iconPrimaryInverseDark)
        private set
    var iconAccentPrimary by mutableStateOf(iconAccentPrimary)
        private set
    var iconAccentSecondary by mutableStateOf(iconAccentSecondary)
        private set
    var statusDanger by mutableStateOf(statusDanger)
        private set
    var statusSuccess by mutableStateOf(statusSuccess)
        private set
    var statusWarning by mutableStateOf(statusWarning)
        private set
    var buttonPrimary by mutableStateOf(buttonPrimary)
        private set
    var buttonPrimaryOnTap by mutableStateOf(buttonPrimaryOnTap)
        private set
    var buttonSecondary by mutableStateOf(buttonSecondary)
        private set
    var buttonSecondaryOnTap by mutableStateOf(buttonSecondaryOnTap)
        private set
    var buttonTertiary by mutableStateOf(buttonTertiary)
        private set
    var buttonTertiaryOnTap by mutableStateOf(buttonTertiaryOnTap)
        private set
    var buttonDisabled by mutableStateOf(buttonDisabled)
        private set
    var buttonTextDark by mutableStateOf(buttonTextDark)
        private set
    var buttonTextLight by mutableStateOf(buttonTextLight)
        private set

    fun copy(
        backgroundGlobe: Color = this.backgroundGlobe,
        backgroundIsland: Color = this.backgroundIsland,
        backgroundOnIsland: Color = this.backgroundOnIsland,
        backgroundOnIslandHover: Color = this.backgroundOnIslandHover,
        backgroundColoured: Color = this.backgroundColoured,
        dividerLight: Color = this.dividerLight,
        dividerDark: Color = this.dividerDark,
        overlayLight: Color = this.overlayLight,
        overlayDark: Color = this.overlayDark,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        textTertiary: Color = this.textTertiary,
        textPrimaryInverseLight: Color = this.textPrimaryInverseLight,
        textPrimaryInverseDark: Color = this.textPrimaryInverseDark,
        textAccentPrimary: Color = this.textAccentPrimary,
        textAccentSecondary: Color = this.textAccentSecondary,
        iconPrimary: Color = this.iconPrimary,
        iconSecondary: Color = this.iconSecondary,
        iconTertiary: Color = this.iconTertiary,
        iconPrimaryInverseLight: Color = this.iconPrimaryInverseLight,
        iconPrimaryInverseDark: Color = this.iconPrimaryInverseDark,
        iconAccentPrimary: Color = this.iconAccentPrimary,
        iconAccentSecondary: Color = this.iconAccentSecondary,
        statusDanger: Color = this.statusDanger,
        statusSuccess: Color = this.statusSuccess,
        statusWarning: Color = this.statusWarning,
        buttonPrimary: Color = this.buttonPrimary,
        buttonPrimaryOnTap: Color = this.buttonPrimaryOnTap,
        buttonSecondary: Color = this.buttonSecondary,
        buttonSecondaryOnTap: Color = this.buttonSecondaryOnTap,
        buttonTertiary: Color = this.buttonTertiary,
        buttonTertiaryOnTap: Color = this.buttonTertiaryOnTap,
        buttonDisabled: Color = this.buttonDisabled,
        buttonTextDark: Color = this.buttonTextDark,
        buttonTextLight: Color = this.buttonTextLight
    ): TennisColors =
        TennisColors(
            backgroundGlobe = backgroundGlobe,
            backgroundIsland = backgroundIsland,
            backgroundOnIsland = backgroundOnIsland,
            backgroundOnIslandHover = backgroundOnIslandHover,
            backgroundColoured = backgroundColoured,
            dividerLight = dividerLight,
            dividerDark = dividerDark,
            overlayLight = overlayLight,
            overlayDark = overlayDark,
            textPrimary = textPrimary,
            textSecondary = textSecondary,
            textTertiary = textTertiary,
            textPrimaryInverseLight = textPrimaryInverseLight,
            textPrimaryInverseDark = textPrimaryInverseDark,
            textAccentPrimary = textAccentPrimary,
            textAccentSecondary = textAccentSecondary,
            iconPrimary = iconPrimary,
            iconSecondary = iconSecondary,
            iconTertiary = iconTertiary,
            iconPrimaryInverseLight = iconPrimaryInverseLight,
            iconPrimaryInverseDark = iconPrimaryInverseDark,
            iconAccentPrimary = iconAccentPrimary,
            iconAccentSecondary = iconAccentSecondary,
            statusDanger = statusDanger,
            statusSuccess = statusSuccess,
            statusWarning = statusWarning,
            buttonPrimary = buttonPrimary,
            buttonPrimaryOnTap = buttonPrimaryOnTap,
            buttonSecondary = buttonSecondary,
            buttonSecondaryOnTap = buttonSecondaryOnTap,
            buttonTertiary = buttonTertiary,
            buttonTertiaryOnTap = buttonTertiaryOnTap,
            buttonDisabled = buttonDisabled,
            buttonTextDark = buttonTextDark,
            buttonTextLight = buttonTextLight
        )

    fun updateColorsFrom(others: TennisColors) {
        backgroundGlobe = others.backgroundGlobe
        backgroundIsland = others.backgroundIsland
        backgroundOnIsland = others.backgroundOnIsland
        backgroundOnIslandHover = others.backgroundOnIslandHover
        backgroundColoured = others.backgroundColoured
        dividerLight = others.dividerLight
        dividerDark = others.dividerDark
        overlayLight = others.overlayLight
        overlayDark = others.overlayDark
        textPrimary = others.textPrimary
        textSecondary = others.textSecondary
        textTertiary = others.textTertiary
        textPrimaryInverseLight = others.textPrimaryInverseLight
        textPrimaryInverseDark = others.textPrimaryInverseDark
        textAccentPrimary = others.textAccentPrimary
        textAccentSecondary = others.textAccentSecondary
        iconPrimary = others.iconPrimary
        iconSecondary = others.iconSecondary
        iconTertiary = others.iconTertiary
        iconPrimaryInverseLight = others.iconPrimaryInverseLight
        iconPrimaryInverseDark = others.iconPrimaryInverseDark
        iconAccentPrimary = others.iconAccentPrimary
        iconAccentSecondary = others.iconAccentSecondary
        statusDanger = others.statusDanger
        statusSuccess = others.statusSuccess
        statusWarning = others.statusWarning
        buttonPrimary = others.buttonPrimary
        buttonPrimaryOnTap = others.buttonPrimaryOnTap
        buttonSecondary = others.buttonSecondary
        buttonSecondaryOnTap = others.buttonSecondaryOnTap
        buttonTertiary = others.buttonTertiary
        buttonTertiaryOnTap = others.buttonTertiaryOnTap
        buttonDisabled = others.buttonDisabled
        buttonTextDark = others.buttonTextDark
        buttonTextLight = others.buttonTextLight
    }
}

internal val LocalColors = staticCompositionLocalOf { TennisDarkColor }
