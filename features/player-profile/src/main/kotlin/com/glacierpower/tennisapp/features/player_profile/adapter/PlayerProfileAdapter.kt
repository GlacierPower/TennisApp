package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.features.player_profile.databinding.ItemsPlayerDetailsBinding
import models.PlayerProfileModel

class PlayerProfileAdapter : RecyclerView.Adapter<PlayerProfileAdapter.PlayerDetailViewHolder>() {

    inner class PlayerDetailViewHolder(private val itemsPlayerDetailsBinding: ItemsPlayerDetailsBinding) :
        RecyclerView.ViewHolder(itemsPlayerDetailsBinding.root) {
        fun bind(playerDetailsModel: PlayerProfileModel) {

            itemsPlayerDetailsBinding.apply {
                this.playerName.text = playerDetailsModel.competitor.name
                this.ranking.text = playerDetailsModel.competitorRankings.first().rank.toString()
                this.countryName.text = playerDetailsModel.competitor.country
                this.ranking.text = playerDetailsModel.competitorRankings.first().rank.toString()

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
        object : DiffUtil.ItemCallback<PlayerProfileModel>() {
            override fun areItemsTheSame(
                oldItem: PlayerProfileModel,
                newItem: PlayerProfileModel
            ): Boolean {
                return oldItem.competitor.id == newItem.competitor.id
            }

            override fun areContentsTheSame(
                oldItem: PlayerProfileModel,
                newItem: PlayerProfileModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}