package api.responce.ranking

import com.squareup.moshi.Json

data class Meta(
    @property:Json(name = "current_page")
    val currentPage: Int,
    val from: Int,
    @property:Json(name = "last_page")
    val lastPage: Int,
    @property:Json(name = "per_page")
    val perPage: Int,
    val to: Int,
    val total: Int
)
