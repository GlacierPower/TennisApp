package model.common

data class ManagerModel(
    val id: Int,
    val slug: String,
    val name: String,
    val nameTranslations: Map<String, String>,
    val nameShort: String,
    val hasPhoto: Boolean,
    val photo: String,
    val dateBirth: String?,
    val nationalityCode: String,
    val performance: PerformanceModel,
    val preferredFormation: String
)
