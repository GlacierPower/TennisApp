package com.glacierpower.tennisapp.features.player_profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.features.player_profile.databinding.ItemsLastEventsBinding
import models.player_summaries.PlayerSummariesModel

class PlayerSummariesAdapter() : RecyclerView.Adapter<PlayerSummariesAdapter.PlayerDetailsViewHolder>() {

    inner class PlayerDetailsViewHolder(private val itemsLastEventsBinding: ItemsLastEventsBinding) :
        RecyclerView.ViewHolder(itemsLastEventsBinding.root) {
        fun bind(lastEventModel: PlayerSummariesModel) {

            itemsLastEventsBinding.apply {
                this.awayTeam.text = lastEventModel.summaries.first().sportEvent.competitors.first().name
                this.homeTeam.text = lastEventModel.summaries.last().sportEvent.competitors.last().name
                this.awayTeamPont.text = lastEventModel.summaries.first().sportEventStatus.homeScore.toString()
                this.secondPlayerSet2.text = lastEventModel.summaries.first().sportEventStatus.awayScore.toString()
//                this.tournament.text = lastEventModel.tournament.name
//                this.tournamentCategory.text = lastEventModel.tournament.category?.name

                this.tournamentDate.text = lastEventModel.summaries.first().sportEvent.startTime

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerDetailsViewHolder {
        return PlayerDetailsViewHolder(
            ItemsLastEventsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PlayerDetailsViewHolder, position: Int) {
        val liveEvent = differ.currentList[position]
        holder.bind(liveEvent)
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<PlayerSummariesModel>() {
            override fun areItemsTheSame(
                oldItem: PlayerSummariesModel,
                newItem: PlayerSummariesModel
            ): Boolean {
                return oldItem.summaries.first() == newItem.summaries.first()
            }

            override fun areContentsTheSame(
                oldItem: PlayerSummariesModel,
                newItem: PlayerSummariesModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}