
package com.glacierpower.tennisapp.features.ranking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.domain.ranking.model.CompetitorRankingsModel
import com.glacierpower.tennisapp.features.ranking.databinding.RankingItemsBinding

class RankingAdapter(private val listener: Listener) :
    RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {
    private val differCallback = object : DiffUtil.ItemCallback<CompetitorRankingsModel>() {
        override fun areItemsTheSame(oldItem: CompetitorRankingsModel, newItem: CompetitorRankingsModel): Boolean {
            return oldItem.rank == newItem.rank && oldItem.competitor.id == newItem.competitor.id
        }

        override fun areContentsTheSame(oldItem: CompetitorRankingsModel, newItem: CompetitorRankingsModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        return RankingViewHolder(
            RankingItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val competitorRanking = differ.currentList[position]
        holder.bind(competitorRanking)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitCompetitorsList(competitors: List<CompetitorRankingsModel>) {
        differ.submitList(competitors)
    }

    inner class RankingViewHolder(private val itemsRankingBinding: RankingItemsBinding) :
        RecyclerView.ViewHolder(itemsRankingBinding.root) {

        fun bind(competitorRanking: CompetitorRankingsModel) {
            itemsRankingBinding.apply {
                ranking.text = competitorRanking.rank.toString()
                points.text = competitorRanking.points.toString()
                rowName.text = competitorRanking.competitor.name

                rowName.setOnClickListener {
                    listener.getId(competitorRanking.competitor.id)
                }
            }
        }
    }
}
