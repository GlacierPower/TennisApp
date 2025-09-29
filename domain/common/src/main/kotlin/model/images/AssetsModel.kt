package model.images

data class AssetsModel(
    val id: String,
    val created: String,
    val updated: String,
    val title: String,
    val description: String,
    val playerId: String? = null,
    val copyright: String,
    val posed: Boolean? = false,
    val links: List<LinksModel>,
    val refs: List<RefsModel> = emptyList(),
    val provider: ProviderModel
)
