
package mappers.player_summaries

import api.responce.player_summaries.Category
import models.player_summaries.CategoryModel

fun Category.toCategoryModel(): CategoryModel {
    return CategoryModel(
        id = id,
        name = name
    )
}
