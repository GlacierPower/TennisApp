package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.LiveEventItemBinding
import com.glacierpower.tennisapp.model.eventModel.EventModel
import com.glacierpower.tennisapp.utils.Constants.PERIOD1
import com.glacierpower.tennisapp.utils.Constants.PERIOD2
import com.glacierpower.tennisapp.utils.Constants.PERIOD3
import com.glacierpower.tennisapp.utils.Constants.SET1
import com.glacierpower.tennisapp.utils.Constants.SET2
import com.glacierpower.tennisapp.utils.Constants.SET3

class LiveEventAdapter : RecyclerView.Adapter<LiveEventAdapter.LiveEventViewHolder>() {

    inner class LiveEventViewHolder(private val liveEventItemBinding: LiveEventItemBinding) :
        RecyclerView.ViewHolder(liveEventItemBinding.root) {
        fun bind(eventModel: EventModel) {
            liveEventItemBinding.apply {
                liveEventItemBinding.firstPlayer.text = eventModel.awayTeam.name
                liveEventItemBinding.secondPlayer.text = eventModel.homeTeam.name
                liveEventItemBinding.firstPlayerPoint.text = eventModel.awayScore.point
                liveEventItemBinding.secondPlayerPoint.text = eventModel.homeScore.point
                liveEventItemBinding.firstPlayerSet1.text = eventModel.awayScore.period1.toString()
                liveEventItemBinding.secondPlayerSet1.text = eventModel.homeScore.period1.toString()
                liveEventItemBinding.firstPlayerSet2.text = eventModel.awayScore.period2.toString()
                liveEventItemBinding.secondPlayerSet2.text = eventModel.homeScore.period2.toString()
                liveEventItemBinding.firstPlayerSet3.text = eventModel.awayScore.period3.toString()
                liveEventItemBinding.secondPlayerSet3.text = eventModel.homeScore.period3.toString()
                when (eventModel.lastPeriod) {
                    PERIOD1 -> liveEventItemBinding.period.text = SET1
                    PERIOD2 -> liveEventItemBinding.period.text = SET2
                    PERIOD3 -> liveEventItemBinding.period.text = SET3
                }
                liveEventItemBinding.firstCountry.text = eventModel.awayTeam.country?.alpha2
                liveEventItemBinding.secondCountry.text = eventModel.homeTeam.country?.alpha2
                liveEventItemBinding.tournament.text = eventModel.tournament.name
                liveEventItemBinding.tournamentCategory.text = eventModel.tournament.category?.name

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveEventViewHolder {
        return LiveEventViewHolder(
            LiveEventItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: LiveEventViewHolder, position: Int) {
        val liveEvent = differ.currentList[position]
        holder.bind(liveEvent)
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<EventModel>() {
            override fun areItemsTheSame(
                oldItem: EventModel,
                newItem: EventModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: EventModel,
                newItem: EventModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}