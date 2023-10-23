package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.RankingItemsBinding
import com.glacierpower.tennisapp.model.rankingModel.RankingModel
import com.glacierpower.tennisapp.presentation.adapter.listener.SearchListener
import com.glacierpower.tennisapp.utils.Constants.FLAG_URL
import com.glacierpower.tennisapp.utils.Constants.IMAGE_FORMAT
import com.squareup.picasso.Picasso

class RankingAdapter(private val searchListener: SearchListener) :
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
        val ranking = differ.currentList[position]
        holder.bind(ranking)

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

                val countryFlag = rankingModel.team.country.alpha2
                Picasso.get()
                    .load("${FLAG_URL}${countryFlag}${IMAGE_FORMAT}")
                    .into(itemsRankingBinding.countryFlag)
            }
            itemsRankingBinding.rowName.setOnClickListener {
                searchListener.getPlayerDetails(rankingModel.team.id)
            }
        }
    }
}