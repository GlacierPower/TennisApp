package mappers

import api.responce.tournament_details.PeriodsRs
import model.common.PeriodsModel

fun PeriodsRs.toPeriodsModel(): PeriodsModel {
    return PeriodsModel(
        current = current,
        period1 = period1,
        period2 = period2,
        period3 = period3,
        period4 = period4,
        period5 = period5,
        point = point
    )
}
