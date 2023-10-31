package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.ItemsNearPlayerEventBinding
import com.glacierpower.tennisapp.model.player_details.PlayerNearEventsModel
import com.glacierpower.tennisapp.presentation.adapter.listener.NearEventListener
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.Extensions.shortDate
import com.squareup.picasso.Picasso

class PlayerNearEventAdapter(private val listener: NearEventListener) :
    RecyclerView.Adapter<PlayerNearEventAdapter.PlayerNearEventViewHolder>() {

    inner class PlayerNearEventViewHolder(private val itemsNearPlayerEventBinding: ItemsNearPlayerEventBinding) :
        RecyclerView.ViewHolder(itemsNearPlayerEventBinding.root) {
        fun bind(nearEventsModel: PlayerNearEventsModel) {
            if (nearEventsModel.nextEvent != null) {
                itemsNearPlayerEventBinding.apply {
                    this.awayTeam.text = nearEventsModel.nextEvent.homeTeam?.name
                    this.homeTeam.text = nearEventsModel.nextEvent.awayTeam.name

                    val date = nearEventsModel.nextEvent.startTimestamp
                    this.tournamentDate.text = date.shortDate(date)

                    this.tournament.text = nearEventsModel.nextEvent.tournament.name
                    this.tournamentCategory.text =
                        nearEventsModel.nextEvent.tournament.category?.name

                    val id = nearEventsModel.nextEvent.tournament.uniqueTournament.id
                    Picasso.get()
                        .load("${Constants.TOURNAMENT_URL}${id}${Constants.IMAGE_KEY}")
                        .into(tournamentImage)

                    val nearEventId = nearEventsModel.nextEvent.id
                    this.awayTeam.setOnClickListener {
                        listener.getEventId(nearEventId)
                    }
                }

            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerNearEventAdapter.PlayerNearEventViewHolder {
        return PlayerNearEventViewHolder(
            ItemsNearPlayerEventBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PlayerNearEventViewHolder, position: Int) {
        val liveEvent = differ.currentList[position]
        holder.bind(liveEvent)
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<PlayerNearEventsModel>() {
            override fun areItemsTheSame(
                oldItem: PlayerNearEventsModel,
                newItem: PlayerNearEventsModel
            ): Boolean {
                return oldItem.nextEvent!!.id == newItem.nextEvent!!.id
            }

            override fun areContentsTheSame(
                oldItem: PlayerNearEventsModel,
                newItem: PlayerNearEventsModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}