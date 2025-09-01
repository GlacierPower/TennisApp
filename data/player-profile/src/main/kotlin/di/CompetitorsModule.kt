package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repository.CompetitorsRepository
import repository.CompetitorsRepositoryImpl
import service.CompetitorsService
import service.CompetitorsServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CompetitorsModule {

    @Binds
    @Singleton
    abstract fun bindCompetitorsRepository(impl: CompetitorsRepositoryImpl): CompetitorsRepository

    @Binds
    @Singleton
    abstract fun bindCompetitorsService(impl: CompetitorsServiceImpl): CompetitorsService
}