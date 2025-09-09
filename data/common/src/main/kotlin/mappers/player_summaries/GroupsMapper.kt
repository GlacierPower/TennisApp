
package mappers.player_summaries

import api.responce.player_summaries.Groups
import model.player_summaries.GroupsModel

fun List<Groups>.toGroupsModel(): List<GroupsModel> {
    return this.map { group ->
        GroupsModel(
            id = group.id,
            name = group.name
        )
    }
}
