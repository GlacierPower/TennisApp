package api.responce.player_summaries

import com.squareup.moshi.Json

data class TotalStatistics(
    val aces: Int,
    @property:Json("backhand_errors")
    val backhandErrors: Int,
    @property:Json("backhand_unforced_errors")
    val backhandUnforcedErrors: Int,
    @property:Json("backhand_winners")
    val backhandWinners: Int,
    @property:Json("breakpoints_won")
    val breakpointsWon: Int,
    @property:Json("double_faults")
    val doubleFaults: Int,
    @property:Json("drop_shot_unforced_errors")
    val dropShotUnforcedErrors: Int,
    @property:Json("drop_shot_winners")
    val dropShotWinners: Int,
    @property:Json("first_serve_points_won")
    val firstServePointsWon: Int,
    @property:Json("first_serve_successful")
    val firstServeSuccessful: Int,
    @property:Json("forehand_errors")
    val forehandErrors: Int,
    @property:Json("forehand_unforced_errors")
    val forehandUnforcedErrors: Int,
    @property:Json("forehand_winners")
    val forehandWinners: Int,
    @property:Json("games_won")
    val gamesWon: Int,
    @property:Json("groundstroke_errors")
    val groundstrokeErrors: Int,
    @property:Json("groundstroke_unforced_errors")
    val groundstrokeUnforcedErrors: Int,
    @property:Json("groundstroke_winners")
    val groundstrokeWinners: Int,
    @property:Json("lob_unforced_errors")
    val lobUnforcedErrors: Int,
    @property:Json("lob_winners")
    val lobWinners: Int,
    @property:Json("max_games_in_a_row")
    val maxGamesInArow: Int,
    @property:Json("max_points_in_a_row")
    val maxPointsInArow: Int,
    @property:Json("overhead_stroke_errors")
    val overheadStrokeErrors: Int,
    @property:Json("overhead_stroke_unforced_errors")
    val overheadStrokeUnforcedErrors: Int,
    @property:Json("overhead_stroke_winners")
    val overheadStrokeWinners: Int,
    @property:Json("points_won")
    val pointsWon: Int,
    @property:Json("points_won_from_last_10")
    val pointsWonFromLast10: Int,
    @property:Json("return_errors")
    val returnErrors: Int,
    @property:Json("return_winners")
    val returnWinners: Int,
    @property:Json("second_serve_points_won")
    val secondServePointsWon: Int,
    @property:Json("second_serve_successful")
    val secondServeSuccessful: Int,
    @property:Json("service_games_won")
    val serviceGamesWon: Int,
    @property:Json("service_points_lost")
    val servicePointsLost: Int,
    @property:Json("service_points_won")
    val servicePointsWon: Int,
    @property:Json("tiebreaks_won")
    val tiebreaksWon: Int,
    @property:Json("total_breakpoints")
    val totalBreakpoints: Int,
    @property:Json("volley_unforced_errors")
    val volleyUnforcedErrors: Int,
    @property:Json("volley_winners")
    val volleyWinners: Int
)
