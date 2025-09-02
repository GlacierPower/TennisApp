package model

data class TeamModel(
    val name: String,
    val slug: String,
    val shortName: String,
    val gender: String,
    val sport: SportModel,
    val userCount: Int,
    val nameCode: String,
    val ranking: Int,
    val disabled: Boolean,
    val national: Boolean,
    val type: Int,
    val id: Int,
    val country: CountryModel,
    val teamColor: ColorModel,
    val fieldTranslationsModel: FieldTranslationsModel
)
