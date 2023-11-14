package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.ItemsSummaryBinding
import com.glacierpower.tennisapp.model.eventDetailsModel.EventDetailsModel
import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import com.glacierpower.tennisapp.utils.Constants.FINISHED
import com.glacierpower.tennisapp.utils.Constants.IN_PROGRESS
import com.glacierpower.tennisapp.utils.Constants.NOT_STARTED

class EventSummaryAdapter :
    RecyclerView.Adapter<EventSummaryAdapter.EventSummaryViewHolder>() {

    inner class EventSummaryViewHolder(private val itemsSummaryBinding: ItemsSummaryBinding) :
        RecyclerView.ViewHolder(itemsSummaryBinding.root) {
        fun bind(eventDetailsModel: EventDetailsModel) {
            itemsSummaryBinding.apply {
                awayTeamName.text = eventDetailsModel.awayTeam.name
                awayTeamCountry.text = eventDetailsModel.awayTeam.country?.alpha2

                homeTeamName.text = eventDetailsModel.homeTeam.name
                homeTeamCountry.text = eventDetailsModel.homeTeam.country?.alpha2

                when (eventDetailsModel.status.type) {
                    NOT_STARTED -> {
                        homeTeamPoint.visibility = View.GONE
                        homeFifthSet.visibility = View.GONE
                        homeFourthSet.visibility = View.GONE
                        homeThirdSet.visibility = View.GONE
                        homeSecondSet.visibility = View.GONE
                        homeFirstSet.visibility = View.GONE
                        homeTeamSetsScore.visibility = View.GONE

                        awayTeamPoint.visibility = View.GONE
                        awayTeamFifthSet.visibility = View.GONE
                        awayTeamFourthSet.visibility = View.GONE
                        awayTeamThirdSet.visibility = View.GONE
                        awayTeamSecondSet.visibility = View.GONE
                        awayTeamFirstSet.visibility = View.GONE
                        awayTeamSetsScore.visibility = View.GONE

                    }
                    IN_PROGRESS -> {

                        homeFirstSet.text = eventDetailsModel.homeScore.period1.toString()
                        homeSecondSet.text = eventDetailsModel.homeScore.period2.toString()
                        homeThirdSet.text = eventDetailsModel.homeScore.period3.toString()
                            homeTeamPoint.text = eventDetailsModel.homeScore.point
                        homeTeamSetsScore.text =
                            eventDetailsModel.homeScore.current.toString()

                        awayTeamFirstSet.text = eventDetailsModel.awayScore.period1.toString()
                        awayTeamSecondSet.text = eventDetailsModel.awayScore.period2.toString()
                        awayTeamThirdSet.text = eventDetailsModel.awayScore.period3.toString()
                        awayTeamPoint.text = eventDetailsModel.awayScore.point
                        awayTeamSetsScore.text =
                            eventDetailsModel.awayScore.current.toString()


                    }
                    FINISHED->{
                        homeFirstSet.text = eventDetailsModel.homeScore.period1.toString()
                        homeSecondSet.text = eventDetailsModel.homeScore.period2.toString()
                        homeThirdSet.text = eventDetailsModel.homeScore.period3.toString()


                        awayTeamFirstSet.text = eventDetailsModel.awayScore.period1.toString()
                        awayTeamSecondSet.text = eventDetailsModel.awayScore.period2.toString()
                        awayTeamThirdSet.text = eventDetailsModel.awayScore.period3.toString()
                        awayTeamPoint.text = eventDetailsModel.awayScore.point

                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventSummaryViewHolder {
        return EventSummaryViewHolder(
            ItemsSummaryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: EventSummaryViewHolder, position: Int) {
        val liveEvent = differ.currentList[position]
        holder.bind(liveEvent)
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<EventDetailsModel>() {
            override fun areItemsTheSame(
                oldItem: EventDetailsModel,
                newItem: EventDetailsModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: EventDetailsModel,
                newItem: EventDetailsModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}