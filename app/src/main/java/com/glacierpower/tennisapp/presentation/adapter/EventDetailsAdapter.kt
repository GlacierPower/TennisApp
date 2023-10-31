package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.ItemsEventDetailBinding
import com.glacierpower.tennisapp.model.eventDetailsModel.EventDetailsModel
import com.glacierpower.tennisapp.presentation.adapter.listener.Listener
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.Constants.PERIOD1
import com.glacierpower.tennisapp.utils.Constants.PERIOD2
import com.glacierpower.tennisapp.utils.Constants.PERIOD3
import com.glacierpower.tennisapp.utils.Constants.RANK
import com.glacierpower.tennisapp.utils.Extensions.fullDate
import com.squareup.picasso.Picasso

class EventDetailsAdapter(private val listener: Listener) :
    RecyclerView.Adapter<EventDetailsAdapter.EventDetailViewHolder>() {

    inner class EventDetailViewHolder(private val itemsEventDetailBinding: ItemsEventDetailBinding) :
        RecyclerView.ViewHolder(itemsEventDetailBinding.root) {
        fun bind(eventDetailsModel: EventDetailsModel) {

            itemsEventDetailBinding.apply {
                this.homeTeamName.text = eventDetailsModel.homeTeam.name
                this.awayTeamName.text = eventDetailsModel.awayTeam.name

                this.homeTeamSet.text = eventDetailsModel.homeScore.current.toString()
                this.awayTeamSet.text = eventDetailsModel.awayScore.current.toString()

                val date = eventDetailsModel.startTimestamp
                this.tvDateTime.text = date.fullDate(date)

                if (eventDetailsModel.status.type == "inprogress") {

                    this.homeTeamGamePoint.text =
                        eventDetailsModel.homeScore.period1.toString()
                    this.awayTeamGamePoint.text =
                        eventDetailsModel.awayScore.period1.toString()
                    this.homeTeamGamePointCurrent.text = eventDetailsModel.awayScore.point
                    this.awayTeamGamePointCurrent.text = eventDetailsModel.homeScore.point

                    when (eventDetailsModel.lastPeriod) {
                        PERIOD1 -> {
                            this.homeTeamGamePoint.text =
                                eventDetailsModel.homeScore.period1.toString()
                            this.awayTeamGamePoint.text =
                                eventDetailsModel.awayScore.period1.toString()
                        }
                        PERIOD2 -> {
                            this.homeTeamGamePoint.text =
                                eventDetailsModel.homeScore.period2.toString()
                            this.awayTeamGamePoint.text =
                                eventDetailsModel.awayScore.period2.toString()
                        }
                        PERIOD3 -> {
                            this.homeTeamGamePoint.text =
                                eventDetailsModel.homeScore.period3.toString()
                            this.awayTeamGamePoint.text =
                                eventDetailsModel.awayScore.period3.toString()
                        }
                    }
                } else {
                    this.homeTeamGamePoint.visibility = View.GONE
                    this.awayTeamGamePoint.visibility = View.GONE
                    this.homeTeamGamePointCurrent.visibility = View.GONE
                    this.awayTeamGamePointCurrent.visibility = View.GONE
                    this.colon.visibility = View.GONE
                    this.status.visibility = View.VISIBLE
                    this.status.text = eventDetailsModel.status.type.uppercase()

                }

                val rankingHome = eventDetailsModel.homeTeam.ranking
                val rankingAway = eventDetailsModel.awayTeam.ranking

                this.homeTeamRanking.text = "$RANK $rankingHome"
                this.awayTeamRanking.text = "$RANK $rankingAway"

                Picasso.get()
                    .load("${Constants.TEAM_IMAGE_URL}${eventDetailsModel.homeTeam.id}${Constants.IMAGE_KEY}")
                    .into(homeTeamImage)

                Picasso.get()
                    .load("${Constants.TEAM_IMAGE_URL}${eventDetailsModel.awayTeam.id}${Constants.IMAGE_KEY}")
                    .into(awayTeamImage)

                this.awayTeamImage.setOnClickListener {
                    listener.getId(eventDetailsModel.awayTeam.id)
                }
                this.homeTeamImage.setOnClickListener {
                    listener.getId(eventDetailsModel.homeTeam.id)
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventDetailViewHolder {
        return EventDetailViewHolder(
            ItemsEventDetailBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: EventDetailViewHolder, position: Int) {
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