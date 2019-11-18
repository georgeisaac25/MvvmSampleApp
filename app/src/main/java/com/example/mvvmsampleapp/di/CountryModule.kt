package com.example.mvvmsampleapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.domain.contract.RepositoryContract
import com.example.domain.usecase.GetCountryUseCase
import com.example.data.datasource.DataRepository
import com.example.data.datasource.LocalDataSource
import com.example.data.datasource.RemoteDataSource
import com.example.data.mapper.MapperForDomainAndDataImpl
import com.example.data.remote.retrofit.ApiInterface
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.ResponseHandler
import com.example.mvvmsampleapp.ApiModule
import com.example.mvvmsampleapp.ApplicationScope
import com.example.mvvmsampleapp.ContextModule
import com.example.mvvmsampleapp.DatabaseModule
import com.example.mvvmsampleapp.country.CountryMapper
import com.example.mvvmsampleapp.country.CountryUiModel
import com.example.mvvmsampleapp.country.ViewModelFactory
import com.example.mvvmsampleapp.database.AppDatabase
import com.example.mvvmsampleapp.database.CountryDao
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [DatabaseModule::class,ApiModule::class,ResponseHandlerModule::class])
class CountryModule {

    @ApplicationScope
    @Provides
    fun provideMapperForDomainAndPresenter()
            : CountryMapper  = CountryMapper()

    @ApplicationScope
    @Provides
    fun provideViewModelFactory(useCase: GetCountryUseCase,mapper : CountryMapper): ViewModelProvider.Factory {
        return ViewModelFactory(useCase,mapper)
    }

    @ApplicationScope
    @Provides
    fun provideUseCase(repositoryContract: RepositoryContract) : GetCountryUseCase {
        return GetCountryUseCase(repositoryContract)
    }

    @ApplicationScope
    @Provides
    fun provideMapperForDomainAndData()
            : MapperForDomainAndData<Country, CountryUseCaseModel>  = MapperForDomainAndDataImpl()

    @ApplicationScope
    @Provides
    fun provideDataRepository(localDataSource: LocalDataSource,remoteDataSource: RemoteDataSource
                              ,mapper: MapperForDomainAndData<Country, CountryUseCaseModel>)
            : RepositoryContract {
        return DataRepository(localDataSource,remoteDataSource,mapper)
    }

    @ApplicationScope
    @Provides
    internal fun provideRemoteDataSource(apiInterface: ApiInterface,responseHandler: ResponseHandler)
            : RemoteDataSource {
        return RemoteDataSource(apiInterface,responseHandler)
    }

    @ApplicationScope
    @Provides
    fun provideRepository(repoDao: CountryDao): LocalDataSource {
        return LocalDataSource(repoDao)
    }

    @ApplicationScope
    @Provides
    fun provideDao(database: AppDatabase): CountryDao {
        return database.countryDao()
    }
}