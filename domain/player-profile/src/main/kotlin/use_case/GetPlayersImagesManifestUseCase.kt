package use_case

import repository.ImagesRepository
import javax.inject.Inject

class GetPlayersImagesManifestUseCase @Inject constructor(
    private val imagesRepository: ImagesRepository
) {
    suspend operator fun invoke() = imagesRepository.getPlayerManifest()
}
