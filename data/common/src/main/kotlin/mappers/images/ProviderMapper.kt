package mappers.images

import api.responce.images.Provider
import model.images.ProviderModel

fun Provider.toProviderModel(): ProviderModel {
    return ProviderModel(
        name = name,
        providerItemId = providerItemId,
        originalPublish = originalPublish
    )
}
