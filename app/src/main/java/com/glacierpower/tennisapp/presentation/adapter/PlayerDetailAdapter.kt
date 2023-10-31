package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.ItemsPlayerDetailsBinding
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.utils.Constants
import com.squareup.picasso.Picasso

class PlayerDetailAdapter : RecyclerView.Adapter<PlayerDetailAdapter.PlayerDetailViewHolder>() {

    inner class PlayerDetailViewHolder(private val itemsPlayerDetailsBinding: ItemsPlayerDetailsBinding) :
        RecyclerView.ViewHolder(itemsPlayerDetailsBinding.root) {
        fun bind(playerDetailsModel: PlayerDetailsModel) {

            itemsPlayerDetailsBinding.apply {
                this.playerName.text = playerDetailsModel.fullName
                this.ranking.text = playerDetailsModel.ranking.toString()
                this.countryName.text = playerDetailsModel.country?.name
                this.tournamentType.text = playerDetailsModel.tournament?.category?.name
                this.ranking.text = playerDetailsModel.ranking.toString()


                val id = playerDetailsModel.id
                val countryCode = playerDetailsModel.country?.alpha2

                Picasso.get()
                    .load("${Constants.TEAM_IMAGE_URL}${id}${Constants.IMAGE_KEY}")
                    .into(playerImage)
                Picasso.get()
                    .load("${Constants.FLAG_URL}${countryCode}${Constants.IMAGE_FORMAT}")
                    .into(countryFlag)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerDetailViewHolder {
        return PlayerDetailViewHolder(
            ItemsPlayerDetailsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PlayerDetailViewHolder, position: Int) {
        val liveEvent = differ.currentList[position]
        holder.bind(liveEvent)
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<PlayerDetailsModel>() {
            override fun areItemsTheSame(
                oldItem: PlayerDetailsModel,
                newItem: PlayerDetailsModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: PlayerDetailsModel,
                newItem: PlayerDetailsModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}