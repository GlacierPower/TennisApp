package repository

import data_source.LocalJsonDataSource
import model.common.country_flag.CountryInfoModel
import javax.inject.Inject

class CountryInfoRepositoryImpl @Inject constructor(
    private val localJsonDataSource: LocalJsonDataSource
) : CountryInfoRepository {
    override suspend fun getCountryInfo(): CountryInfoModel? {
        val jsonString = localJsonDataSource.readJsonFromAssets("country.json")
        return jsonString?.let { localJsonDataSource.parseJson(it) }
    }
}
