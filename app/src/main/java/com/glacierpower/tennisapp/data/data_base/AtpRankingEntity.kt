package com.glacierpower.tennisapp.data.data_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.glacierpower.tennisapp.data.service.responce.Country

@Entity(tableName = "rankingEntity")
data class AtpRankingEntity(
    @PrimaryKey(autoGenerate = true)
    val bestRanking:Int,
    val bestRankingDateTimestamp: Int,
    val country: Country

)
