
package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import repository.PlayerDetailsRepository
import repository.PlayerDetailsRepositoryImpl
import service.PlayerDetailsService
import service.PlayerDetailsServiceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class CompetitorsModule {

    @Binds
    @Singleton
    abstract fun bindCompetitorsRepository(impl: PlayerDetailsRepositoryImpl): PlayerDetailsRepository

    @Binds
    @Singleton
    abstract fun bindCompetitorsService(impl: PlayerDetailsServiceImpl): PlayerDetailsService
}
