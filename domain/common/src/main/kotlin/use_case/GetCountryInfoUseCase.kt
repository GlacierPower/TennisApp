package use_case

import repository.CountryInfoRepository
import javax.inject.Inject

class GetCountryInfoUseCase @Inject constructor(
    private val countryInfoRepository: CountryInfoRepository
) {
    suspend operator fun invoke() = countryInfoRepository.getCountryInfo()
}
