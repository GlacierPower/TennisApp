package mappers.player_summaries

import api.responce.player_summaries.Channels
import models.player_summaries.ChannelsModel

fun List<Channels>.toChannelModel(): List<ChannelsModel> {
    return this.map {
        ChannelsModel(
            name = it.name
        )
    }
}
