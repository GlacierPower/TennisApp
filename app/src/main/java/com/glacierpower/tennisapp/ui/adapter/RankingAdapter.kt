package com.glacierpower.tennisapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.RankingItemsBinding
import com.glacierpower.tennisapp.model.RankingModel

class RankingAdapter :
    RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RankingAdapter.RankingViewHolder {
        return RankingViewHolder(
            RankingItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RankingAdapter.RankingViewHolder, position: Int) {
        val news = differ.currentList[position]
        holder.bind(news)

    }

    private val differCallback =
        object : DiffUtil.ItemCallback<RankingModel>() {
            override fun areItemsTheSame(
                oldItem: RankingModel,
                newItem: RankingModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RankingModel,
                newItem: RankingModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class RankingViewHolder(private val itemsRankingBinding: RankingItemsBinding) :
        RecyclerView.ViewHolder(itemsRankingBinding.root) {
        fun bind(rankingModel: RankingModel) {
            itemsRankingBinding.apply {
                itemsRankingBinding.ranking.text = "${rankingModel.ranking}."
                itemsRankingBinding.points.text = rankingModel.points.toString()
                itemsRankingBinding.rowName.text = rankingModel.rowName
            }
        }
    }
}