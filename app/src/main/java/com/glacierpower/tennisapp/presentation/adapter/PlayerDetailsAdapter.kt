package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.R
import com.glacierpower.tennisapp.databinding.ItemsPlayerDetailsBinding
import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.Extensions.convertToString
import com.squareup.picasso.Picasso

class PlayerDetailsAdapter : RecyclerView.Adapter<PlayerDetailsAdapter.PlayerDetailsViewHolder>() {

    inner class PlayerDetailsViewHolder(private val itemsPlayerDetailsBinding: ItemsPlayerDetailsBinding) :
        RecyclerView.ViewHolder(itemsPlayerDetailsBinding.root) {
        fun bind(lastEventModel: LastEventModel) {

            itemsPlayerDetailsBinding.apply {
                this.awayTeam.text = lastEventModel.awayTeam.name
                this.homeTeam.text = lastEventModel.homeTeam.name
                this.awayTeamPont.text = lastEventModel.awayScore?.current.toString()
                this.secondPlayerSet2.text = lastEventModel.homeScore.current.toString()
                this.tournament.text = lastEventModel.tournament.name
                this.tournamentCategory.text = lastEventModel.tournament.category?.name

                val date = lastEventModel.startTimestamp
                this.tournamentDate.text = date.convertToString(date)

                val id = lastEventModel.tournament.uniqueTournament.id
                Picasso.get()
                    .load("${Constants.TOURNAMENT_URL}${id}${Constants.IMAGE_KEY}")
                    .into(itemsPlayerDetailsBinding.tournamentImage)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerDetailsViewHolder {
        return PlayerDetailsViewHolder(
            ItemsPlayerDetailsBinding.inflate(
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
        object : DiffUtil.ItemCallback<LastEventModel>() {
            override fun areItemsTheSame(
                oldItem: LastEventModel,
                newItem: LastEventModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: LastEventModel,
                newItem: LastEventModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}