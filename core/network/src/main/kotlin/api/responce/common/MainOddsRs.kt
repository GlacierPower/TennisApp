package api.responce.common

import com.squareup.moshi.Json

data class MainOddsRs(
    @property:Json("outcome_1")
    val outcome1: OutcomeRs,
    @property:Json("outcome_2")
    val outcome2: OutcomeRs
)
