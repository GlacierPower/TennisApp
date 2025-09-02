
package mappers.player_summaries

import api.responce.player_summaries.Totals
import models.player_summaries.TotalsModel

fun Totals.toTotalsModel(): TotalsModel {
    return TotalsModel(
        competitors = competitors.toCompetitorsTotalModel()
    )
}
