package model.common

data class SectionModel(
    val id: Int,
    val sportId: Int,
    val slug: String,
    val name: String,
    val nameTranslations: NameTranslationsModel?,
    val priority: Int,
    val flag: String
)
