package com.glacierpower.tennisapp.data.dao

import androidx.room.TypeConverter
import com.glacierpower.tennisapp.data.data_base.EntityCountry
import com.glacierpower.tennisapp.data.data_base.EntityTeam
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromCountry(country: EntityCountry): String = (country.name)


    @TypeConverter
    fun toCountry(name: String): EntityCountry = EntityCountry(name, name)

    @TypeConverter
    fun fromTeam(team: EntityTeam): String {
        return Gson().toJson(team).toString()
    }

    @TypeConverter
    fun toTeam(value: String): EntityTeam{
        val team = object : TypeToken<EntityTeam>() {}.type
        return Gson().fromJson(value, team)
    }


}