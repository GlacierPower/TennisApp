package mappers

import api.responce.common.TeamColor
import model.ColorModel

fun TeamColor.toTeamColorModel(): ColorModel {
    return ColorModel(
        primary,
        secondary,
        text
    )
}