package model.common

data class SportModel(
    val id: Int,
    val slug: String,
    val name: String,
    val nameTranslations: NameTranslationsModel?
)
