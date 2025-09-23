package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repository.CountryInfoRepository
import repository.CountryInfoRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CountryInfoModule {

    @Binds
    @Singleton
    abstract fun provideMyRepository(impl: CountryInfoRepositoryImpl): CountryInfoRepository
}
