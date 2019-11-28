package com.example.mvvmsampleapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.domain.contract.RepositoryContract
import com.example.domain.usecase.GetCountryUseCase
import com.example.data.datasource.DataRepository
import com.example.data.datasource.LocalDataSource
import com.example.data.datasource.RemoteDataSource
import com.example.data.mapper.LocalMapperForCountry
import com.example.data.mapper.RemoteMapperForCountry
import com.example.data.remote.retrofit.ApiInterface
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.ResultHandler
import com.example.mvvmsampleapp.country.CountryMapper
import com.example.mvvmsampleapp.country.ViewModelFactory
import com.example.mvvmsampleapp.database.AppDatabase
import com.example.mvvmsampleapp.database.CountryDao
import com.example.mvvmsampleapp.database.CountryEntity
import dagger.Module
import dagger.Provides

@Module
class CountryModule {

    @CountryScope
    @Provides
    fun provideMapperForDomainAndPresenter()
            : CountryMapper = CountryMapper()

    @CountryScope
    @Provides
    fun provideViewModelFactory(
        useCase: GetCountryUseCase,
        mapper: CountryMapper
    ): ViewModelProvider.Factory {
        return ViewModelFactory(useCase, mapper)
    }

    @CountryScope
    @Provides
    fun provideUseCase(repositoryContract: RepositoryContract): GetCountryUseCase {
        return GetCountryUseCase(repositoryContract)
    }

    @CountryScope
    @Provides
    fun provideRemoteMapperForDomainAndData()
            : MapperForDomainAndData<Country, CountryUseCaseModel> = RemoteMapperForCountry()

    @CountryScope
    @Provides
    fun provideLocalMapperForDomainAndData()
            : MapperForDomainAndData<CountryEntity, CountryUseCaseModel> = LocalMapperForCountry()

    @CountryScope
    @Provides
    fun provideDataRepository(
        localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource
        , remoteMapper: MapperForDomainAndData<Country, CountryUseCaseModel>
        , localMapper: MapperForDomainAndData<CountryEntity, CountryUseCaseModel>
    )
            : RepositoryContract {
        return DataRepository(localDataSource, remoteDataSource, remoteMapper, localMapper)
    }

    @CountryScope
    @Provides
    fun provideRemoteDataSource(apiInterface: ApiInterface, responseHandler: ResultHandler)
            : RemoteDataSource {
        return RemoteDataSource(apiInterface, responseHandler)
    }

    @CountryScope
    @Provides
    fun provideRepository(repoDao: CountryDao, responseHandler: ResultHandler): LocalDataSource {
        return LocalDataSource(repoDao, responseHandler)
    }

    @CountryScope
    @Provides
    fun provideDao(database: AppDatabase): CountryDao {
        return database.countryDao()
    }
}