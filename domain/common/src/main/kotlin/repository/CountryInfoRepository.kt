package repository

import model.common.country_flag.CountryInfoModel

interface CountryInfoRepository {
    suspend fun getCountryInfo(): CountryInfoModel?
}
