package models.player_summaries

data class SportEventModel(
    val id: String,
    val startTime: String,
    val startTimeConfirmed: Boolean,
    val sportEventContext: SportEventContextModel,
    val coverage:CoverageModel,
    val competitors: List<CompetitorsModel>,
    val venue: VenueModel
)
