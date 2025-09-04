package api.responce.player_summaries

import com.squareup.moshi.Json

data class TotalStatistics(
    val aces: Int? = null,
    @property:Json("backhand_errors")
    val backhandErrors: Int? = null,
    @property:Json("backhand_unforced_errors")
    val backhandUnforcedErrors: Int? = null,
    @property:Json("backhand_winners")
    val backhandWinners: Int? = null,
    @property:Json("breakpoints_won")
    val breakpointsWon: Int? = null,
    @property:Json("double_faults")
    val doubleFaults: Int? = null,
    @property:Json("drop_shot_unforced_errors")
    val dropShotUnforcedErrors: Int? = null,
    @property:Json("drop_shot_winners")
    val dropShotWinners: Int? = null,
    @property:Json("first_serve_points_won")
    val firstServePointsWon: Int? = null,
    @property:Json("first_serve_successful")
    val firstServeSuccessful: Int? = null,
    @property:Json("forehand_errors")
    val forehandErrors: Int? = null,
    @property:Json("forehand_unforced_errors")
    val forehandUnforcedErrors: Int? = null,
    @property:Json("forehand_winners")
    val forehandWinners: Int? = null,
    @property:Json("games_won")
    val gamesWon: Int? = null,
    @property:Json("groundstroke_errors")
    val groundstrokeErrors: Int? = null,
    @property:Json("groundstroke_unforced_errors")
    val groundstrokeUnforcedErrors: Int? = null,
    @property:Json("groundstroke_winners")
    val groundstrokeWinners: Int? = null,
    @property:Json("lob_unforced_errors")
    val lobUnforcedErrors: Int? = null,
    @property:Json("lob_winners")
    val lobWinners: Int? = null,
    @property:Json("max_games_in_a_row")
    val maxGamesInArow: Int? = null,
    @property:Json("max_points_in_a_row")
    val maxPointsInArow: Int? = null,
    @property:Json("overhead_stroke_errors")
    val overheadStrokeErrors: Int? = null,
    @property:Json("overhead_stroke_unforced_errors")
    val overheadStrokeUnforcedErrors: Int? = null,
    @property:Json("overhead_stroke_winners")
    val overheadStrokeWinners: Int? = null,
    @property:Json("points_won")
    val pointsWon: Int? = null,
    @property:Json("points_won_from_last_10")
    val pointsWonFromLast10: Int? = null,
    @property:Json("return_errors")
    val returnErrors: Int? = null,
    @property:Json("return_winners")
    val returnWinners: Int? = null,
    @property:Json("second_serve_points_won")
    val secondServePointsWon: Int? = null,
    @property:Json("second_serve_successful")
    val secondServeSuccessful: Int? = null,
    @property:Json("service_games_won")
    val serviceGamesWon: Int? = null,
    @property:Json("service_points_lost")
    val servicePointsLost: Int? = null,
    @property:Json("service_points_won")
    val servicePointsWon: Int? = null,
    @property:Json("tiebreaks_won")
    val tiebreaksWon: Int? = null,
    @property:Json("total_breakpoints")
    val totalBreakpoints: Int? = null,
    @property:Json("volley_unforced_errors")
    val volleyUnforcedErrors: Int? = null,
    @property:Json("volley_winners")
    val volleyWinners: Int? = null
)
