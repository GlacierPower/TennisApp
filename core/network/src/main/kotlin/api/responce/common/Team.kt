package api.responce.common

data class Team(
    val name: String,
    val slug: String,
    val shortName: String,
    val gender: String,
    val sport: Sport,
    val userCount: Int,
    val nameCode: String,
    val ranking: Int,
    val disabled: Boolean,
    val national: Boolean,
    val type: Int,
    val id: Int,
    val country: Country,
    val teamColor: TeamColor,
    val fieldTranslations: FieldTranslations
)
