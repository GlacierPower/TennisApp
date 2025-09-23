package models.player_details.events

data class MetaModel(
    val currentPage: Int,
    val from: Int,
    val lastPage: Int?,
    val perPage: Int,
    val to: Int,
    val total: Int?
)
