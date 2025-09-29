
package mappers.player_summaries

import api.responce.player_summaries.Totals
import model.player_summaries.TotalsModel

fun Totals.toTotalsModel(): TotalsModel {
    return TotalsModel(
        competitors = competitors.toCompetitorsTotalModel()
    )
}
