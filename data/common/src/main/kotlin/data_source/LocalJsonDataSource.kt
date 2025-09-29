package data_source

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import model.common.country_flag.CountryInfoModel
import timber.log.Timber
import javax.inject.Inject

class LocalJsonDataSource @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    private val json = Json { ignoreUnknownKeys = true }

    fun readJsonFromAssets(fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            Timber.tag(e.message.orEmpty()).e(e.message.orEmpty())
            null
        }
    }

    fun parseJson(jsonString: String): CountryInfoModel? {
        return try {
            json.decodeFromString<CountryInfoModel>(jsonString)
        } catch (e: Exception) {
            Timber.tag(e.message.orEmpty()).e(e.message.orEmpty())
            null
        }
    }
}
