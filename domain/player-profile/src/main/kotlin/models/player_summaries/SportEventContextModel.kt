package models.player_summaries

data class SportEventContextModel(
    val sport: SportModel,
    val category: CategoryModel,
    val competition: CompetitionModel,
    val season: SeasonModel,
    val stage: StageModel,
    val round: RoundModel,
    val groups : List<GroupsModel>,
    val mode:ModeModel
)
