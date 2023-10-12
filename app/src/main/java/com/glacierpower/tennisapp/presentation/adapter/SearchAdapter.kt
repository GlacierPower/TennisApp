package com.glacierpower.tennisapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glacierpower.tennisapp.databinding.SearchItemsBinding
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel
import com.glacierpower.tennisapp.utils.Constants.IMAGE_KEY
import com.glacierpower.tennisapp.utils.Constants.TEAM_IMAGE_URL
import com.squareup.picasso.Picasso

class SearchAdapter :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.SearchViewHolder {
        return SearchViewHolder(
            SearchItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchViewHolder, position: Int) {
        val search = differ.currentList[position]
        holder.bind(search)

    }

    private val differCallback =
        object : DiffUtil.ItemCallback<SearchResultModel>() {
            override fun areItemsTheSame(
                oldItem: SearchResultModel,
                newItem: SearchResultModel
            ): Boolean {
                return oldItem.entityModel?.id == newItem.entityModel?.id
            }

            override fun areContentsTheSame(
                oldItem: SearchResultModel,
                newItem: SearchResultModel
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class SearchViewHolder(private val searchItemsBinding: SearchItemsBinding) :
        RecyclerView.ViewHolder(searchItemsBinding.root) {
        fun bind(searchResultModel: SearchResultModel) {
            searchItemsBinding.apply {
                searchItemsBinding.tvPlayerName.text = searchResultModel.entityModel?.name
                searchItemsBinding.tvPlayerCountry.text =
                    searchResultModel.entityModel?.country?.name
                val id = searchResultModel.entityModel?.id
                Picasso.get()
                    .load("$TEAM_IMAGE_URL$id$IMAGE_KEY")
                    .into(ivPlayer)
            }

        }
    }
}