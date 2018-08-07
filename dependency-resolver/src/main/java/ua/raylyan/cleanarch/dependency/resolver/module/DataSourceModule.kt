package ua.raylyan.cleanarch.dependency.resolver.module

import dagger.Binds
import dagger.Module
import ua.raylyan.cleanarch.domain.contract.datasource.PostCacheDataSource
import ua.raylyan.cleanarch.domain.contract.datasource.PostNetworkDataSource
import ua.raylyan.cleanarch.platform.cache.datasource.PostCacheDataSourceImpl
import ua.raylyan.cleanarch.platform.network.datasource.PostNetworkDataSourceImpl
import javax.inject.Singleton


@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindPostNetworkDataSource(dataSource: PostNetworkDataSourceImpl): PostNetworkDataSource

    @Binds
    @Singleton
    abstract fun bindPostCacheDataSource(dataSource: PostCacheDataSourceImpl): PostCacheDataSource
}