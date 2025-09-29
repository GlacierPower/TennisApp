package mappers.images

import api.responce.images.EntityIds
import model.images.EntityIdsModel

fun List<EntityIds>.toEntityIdsModel(): List<EntityIdsModel> {
    return this.map { entityIds ->
        EntityIdsModel(
            origin = entityIds.origin,
            id = entityIds.id,
            sport = entityIds.sport
        )
    }
}
