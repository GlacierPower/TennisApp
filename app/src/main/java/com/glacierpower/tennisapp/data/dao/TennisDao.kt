package com.glacierpower.tennisapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.glacierpower.tennisapp.data.data_base.AtpRankingEntity

@Dao
interface TennisDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAtpRanking(atpRankingEntity: AtpRankingEntity)
}
