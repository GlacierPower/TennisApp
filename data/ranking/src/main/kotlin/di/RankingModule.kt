
package di

import com.glacierpower.tennisapp.domain.ranking.repository.RankingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repository.RankingRepositoryImpl
import service.RankingService
import service.RankingServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RankingModule {

    @Binds
    @Singleton
    abstract fun bindRankingRepository(impl: RankingRepositoryImpl): RankingRepository

    @Binds
    @Singleton
    abstract fun bindRankingService(impl: RankingServiceImpl): RankingService
}
