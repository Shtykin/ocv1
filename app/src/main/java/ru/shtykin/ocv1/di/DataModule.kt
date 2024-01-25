package ru.shtykin.ocv1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.shtykin.ocv1.data.repository.RepositoryImpl
import ru.shtykin.ocv1.domain.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(

    ): Repository {
        return RepositoryImpl()
    }

}