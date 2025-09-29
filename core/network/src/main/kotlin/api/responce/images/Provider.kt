package api.responce.images

import com.squareup.moshi.Json

data class Provider(
    val name: String,
    @property:Json("provider_item_id")
    val providerItemId: String,
    @property:Json("original_publish")
    val originalPublish: String
)
