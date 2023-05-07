package com.glacierpower.tennisapp.data.dao

import android.content.Context
import androidx.room.*
import com.glacierpower.tennisapp.data.data_base.AtpRankingEntity

@Database(entities = [AtpRankingEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TennisDataBase : RoomDatabase() {

    abstract fun getTennisDao(): TennisDao

    companion object {
        private const val DATABASE_NAME = "tennis_base"
        private var DB_INSTANCE: TennisDataBase? = null


        fun getTennisDataBaseInstance(context: Context): TennisDataBase {
            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    TennisDataBase::class.java,
                    DATABASE_NAME
                )
                .addMigrations()
                .build()
                .also { DB_INSTANCE = it }
        }
    }
}