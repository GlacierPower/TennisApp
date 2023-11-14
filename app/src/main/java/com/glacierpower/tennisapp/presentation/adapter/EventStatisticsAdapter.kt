package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.ItemsStatisticsLayoutBinding
import com.glacierpower.tennisapp.model.event_statistics_model.EventStatisticsModel
import com.glacierpower.tennisapp.utils.Constants.ACES
import com.glacierpower.tennisapp.utils.Constants.ALL
import com.glacierpower.tennisapp.utils.Constants.BREAK_POINTS_SAVED
import com.glacierpower.tennisapp.utils.Constants.BREAK_POINT_CONVERTED
import com.glacierpower.tennisapp.utils.Constants.DOUBLE_FAULTS
import com.glacierpower.tennisapp.utils.Constants.FIRST_SERVE
import com.glacierpower.tennisapp.utils.Constants.FIRST_SERVE_POINTS
import com.glacierpower.tennisapp.utils.Constants.FIRST_SERVE_RETURN_POINTS
import com.glacierpower.tennisapp.utils.Constants.GAMES
import com.glacierpower.tennisapp.utils.Constants.MAX_GAMES_IN_A_ROW
import com.glacierpower.tennisapp.utils.Constants.MAX_POINTS_IN_A_ROW
import com.glacierpower.tennisapp.utils.Constants.POINTS
import com.glacierpower.tennisapp.utils.Constants.RETURN
import com.glacierpower.tennisapp.utils.Constants.RETURN_POINTS_WON
import com.glacierpower.tennisapp.utils.Constants.SECOND_SERVE_POINTS
import com.glacierpower.tennisapp.utils.Constants.SECOND_SERVE_RETURN_POINTS
import com.glacierpower.tennisapp.utils.Constants.SERVICE
import com.glacierpower.tennisapp.utils.Constants.SERVICE_GAMES_WON
import com.glacierpower.tennisapp.utils.Constants.SERVICE_POINTS_WON
import com.glacierpower.tennisapp.utils.Constants.TOTAL_WON
import com.glacierpower.tennisapp.utils.Extensions.awayToString
import com.glacierpower.tennisapp.utils.Extensions.homeToString
import com.glacierpower.tennisapp.utils.Extensions.removeBrackets

class EventStatisticsAdapter :
    RecyclerView.Adapter<EventStatisticsAdapter.EventStatisticsViewHolder>() {

    inner class EventStatisticsViewHolder(private val itemsStatisticsLayoutBinding: ItemsStatisticsLayoutBinding) :
        RecyclerView.ViewHolder(itemsStatisticsLayoutBinding.root) {
        fun bind(eventStatisticsModel: EventStatisticsModel) {

            itemsStatisticsLayoutBinding.apply {

                awayTeamAces.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, SERVICE, ACES).toString()
                )
                homeTeamAces.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, SERVICE, ACES).toString()
                )
                awayTeamDoubleFaults.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, SERVICE, DOUBLE_FAULTS).toString()
                )
                homeTeamDoubleFaults.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, SERVICE, DOUBLE_FAULTS).toString()
                )
                awayTeamFirstServePercentage.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, SERVICE, FIRST_SERVE).toString()
                )
                homeTeamFirstServePercentage.text = removeBrackets(
                    eventStatisticsModel.homeToString(
                        ALL, SERVICE,
                        FIRST_SERVE
                    ).toString()
                )

                awayTeamFirstServePointWon.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, SERVICE, FIRST_SERVE_POINTS).toString()
                )
                homeTeamFirstServePointWon.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, SERVICE, FIRST_SERVE_POINTS).toString()
                )
                awayTeamSecondServePointWon.text = removeBrackets(
                    eventStatisticsModel.awayToString(
                        ALL, SERVICE,
                        SECOND_SERVE_POINTS
                    ).toString()
                )
                homeTeamSecondServePointWon.text = removeBrackets(
                    eventStatisticsModel.homeToString(
                        ALL, SERVICE,
                        SECOND_SERVE_POINTS
                    ).toString()
                )

                awayTeamBreakPointsSaved.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, SERVICE, BREAK_POINTS_SAVED).toString()
                )
                homeTeamBreakPointsSaved.text = removeBrackets(
                    eventStatisticsModel.homeToString(
                        ALL, SERVICE,
                        BREAK_POINTS_SAVED
                    ).toString()
                )



                awayTeamFirstServeReturnPoints.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, RETURN, FIRST_SERVE_RETURN_POINTS)
                        .toString()
                )

                homeTeamFirstServeReturnPoints.text = removeBrackets(
                    eventStatisticsModel.homeToString(
                        ALL, RETURN,
                        FIRST_SERVE_RETURN_POINTS
                    ).toString()
                )

                awayTeamSecondServeReturnPoints.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, RETURN, SECOND_SERVE_RETURN_POINTS)
                        .toString()
                )
                homeTeamSecondServeReturnPoints.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, RETURN, SECOND_SERVE_RETURN_POINTS)
                        .toString()
                )


                awayTeamTeamBreakPointsConverted.text = removeBrackets(
                    eventStatisticsModel.awayToString(
                        ALL,
                        RETURN, BREAK_POINT_CONVERTED
                    ).toString()
                )
                homeTeamBreakPointsConverted.text = removeBrackets(
                    eventStatisticsModel.homeToString(
                        ALL,
                        RETURN, BREAK_POINT_CONVERTED
                    ).toString()
                )


                homeTeamMaxPointsInARow.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, POINTS, MAX_POINTS_IN_A_ROW).toString()
                )
                awayTeamTeamMaxPointsInARow.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, POINTS, MAX_POINTS_IN_A_ROW).toString()
                )
                homeTeamServicePointsWon.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, POINTS, SERVICE_POINTS_WON).toString()
                )
                awayTeamServicePointsWon.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, POINTS, SERVICE_POINTS_WON).toString()
                )
                homeTeamReturnPointsWon.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, POINTS, RETURN_POINTS_WON).toString()
                )
                awayTeamReturnPointsWon.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, POINTS, RETURN_POINTS_WON).toString()
                )


                homeTeamMaxGamesInARow.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, GAMES, MAX_GAMES_IN_A_ROW).toString()
                )
                awayTeamTeamMaxGamesInARow.text = removeBrackets(
                    eventStatisticsModel.awayToString(ALL, GAMES, MAX_GAMES_IN_A_ROW).toString()
                )
                homeTeamServiceGamsesWon.text = removeBrackets(
                    eventStatisticsModel.homeToString(ALL, GAMES, SERVICE_GAMES_WON).toString()
                )
                awayTeamServiceGamesWon.text = removeBrackets(
                    eventStatisticsModel.awayToString(
                        ALL, GAMES,
                        SERVICE_GAMES_WON
                    ).toString()
                )
                homeTeamTotalWon.text = removeBrackets(
                    eventStatisticsModel.homeToString(
                        ALL, GAMES,
                        TOTAL_WON
                    ).toString()
                )
                awayTeamTotalWon.text = removeBrackets(
                    eventStatisticsModel.awayToString(
                        ALL, GAMES,
                        TOTAL_WON
                    ).toString()
                )

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventStatisticsViewHolder {
        return EventStatisticsViewHolder(
            ItemsStatisticsLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: EventStatisticsViewHolder, position: Int) {
        val liveEvent = differ.currentList[position]
        holder.bind(liveEvent)
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<EventStatisticsModel>() {
            override fun areItemsTheSame(
                oldItem: EventStatisticsModel,
                newItem: EventStatisticsModel
            ): Boolean {
                return oldItem.statistics == newItem.statistics
            }

            override fun areContentsTheSame(
                oldItem: EventStatisticsModel,
                newItem: EventStatisticsModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}