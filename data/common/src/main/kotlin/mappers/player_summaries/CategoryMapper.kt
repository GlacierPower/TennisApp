
package mappers.player_summaries

import api.responce.player_summaries.Category
import model.player_summaries.CategoryModel

fun Category.toCategoryModel(): CategoryModel {
    return CategoryModel(
        id = id,
        name = name
    )
}
