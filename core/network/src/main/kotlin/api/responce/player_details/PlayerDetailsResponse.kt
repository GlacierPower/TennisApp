package api.responce.player_details

import api.responce.common.Country
import api.responce.common.Sport
import api.responce.common.TeamColor
import api.responce.live_event.Category
import api.responce.live_event.Tournament
import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    @SerializedName("team")
    val team: PlayerDetailsResponse
)

data class PlayerDetailsResponse(
    val category: Category?,
    val country: Country?,
    val disabled:Boolean,
    val fullName:String?,
    val gender:String?,
    val id:Int,
    val name:String?,
    val nameCode:String?,
    val national:Boolean,
    @SerializedName("playerTeamInfoDetails")
    val playerTeamInfoDetails: PlayerTeamInfoDetails?,
    val ranking:Int,
    val shortName:String,
    val slug:String?,
    val sport: Sport?,
    val teamColor: TeamColor?,
    val tournament: Tournament?,
    val type:Int,
    val userCount:Int


)
