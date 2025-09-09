package repository

interface ImagesRepository {
    suspend fun getPlayerManifest(): Map<String?, String>
}
