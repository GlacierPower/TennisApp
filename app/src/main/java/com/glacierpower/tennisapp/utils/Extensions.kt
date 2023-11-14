package com.glacierpower.tennisapp.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.glacierpower.tennisapp.model.event_statistics_model.EventStatisticsModel
import java.text.SimpleDateFormat
import java.util.*

object Extensions {

    fun Fragment.navigate(destination: Int) {
        findNavController().navigate(destination)
    }


    fun shortDate(
        time: Long,
        timeZone: TimeZone = TimeZone.getTimeZone("Europe/Minsk")
    ): String {
        val sdf = SimpleDateFormat("dd.MM.", Locale.getDefault())
        sdf.timeZone = timeZone
        return sdf.format(time * 1000L)
    }

    fun fullDate(
        time: Long,
        timeZone: TimeZone = TimeZone.getTimeZone("Europe/Minsk")
    ): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        sdf.timeZone = timeZone
        return sdf.format(time * 1000L)
    }

    fun EventStatisticsModel.awayToString(
        period: String,
        group: String,
        name: String
    ): List<List<List<String>>> {
        val eventStatisticsModel = EventStatisticsModel(
            statistics
        )
        return eventStatisticsModel.statistics.filter {
            it.period == period
        }.map {
            it.groups.filter {
                it.groupName == group
            }.map {
                it.statisticsItemModels.filter {
                    it.name == name
                }.map {
                    it.away
                }
            }
        }
    }

    fun EventStatisticsModel.homeToString(
        period: String,
        group: String,
        name: String
    ): List<List<List<String>>> {
        val eventStatisticsModel = EventStatisticsModel(
            statistics
        )
        return eventStatisticsModel.statistics.filter {
            it.period == period
        }.map {
            it.groups.filter {
                it.groupName == group
            }.map {
                it.statisticsItemModels.filter {
                    it.name == name
                }.map {
                    it.home
                }
            }
        }
    }



    fun removeBrackets(str: String):String{
        return str.replace('[', ' ').replace(']', ' ')
    }

}






