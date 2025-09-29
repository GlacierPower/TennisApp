package mappers.images

import api.responce.images.Refs
import model.images.RefsModel

fun List<Refs>.toRefsModel(): List<RefsModel> {
    return this.map { ref ->
        RefsModel(
            name = ref.name,
            type = ref.type,
            sport = ref.sport,
            sportRadarId = ref.sportRadarId,
            primary = ref.primary,
            entityIds = ref.entityIds.toEntityIdsModel()
        )
    }
}
