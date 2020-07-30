package com.example.data

import com.example.data.datasource.DataRepository
import com.example.data.datasource.LocalDataSource
import com.example.data.datasource.RemoteDataSource
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.domain.resultmapper.Status
import com.example.mvvmsampleapp.database.CountryDao
import com.example.mvvmsampleapp.database.CountryEntity
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
class DataRepositoryTest {


    //    @get:Rule
//    var rule = CoroutineTestRule()
    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remote: RemoteDataSource

    @Mock
    lateinit var countryDao: CountryDao

    @Mock
    lateinit var remoteMapper: MapperForDomainAndData<Country, CountryUseCaseModel>

    @Mock
    lateinit var localMapper: MapperForDomainAndData<CountryEntity, CountryUseCaseModel>

//    @InjectMocks
//    lateinit var  sut : DataRepository

    lateinit var dataRepository: DataRepository

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this);
        //Dispatchers.setMain(Dispatchers.Unconfined)
        dataRepository = DataRepository(localDataSource, remote, remoteMapper, localMapper)
    }

    @Test
    fun test_getCountry_localSourceCountZero() = runBlocking<Unit> {

            whenever(localDataSource.getCountryCount()).thenReturn(10)
            val result: Result<List<CountryEntity>> =
                Result<List<CountryEntity>>(Status.SUCCESS, null, null);
            whenever(localMapper.getUseCaseModel(result)).thenReturn(Result.success(listOf()))
            dataRepository.getCountry()
            verify(localDataSource).getCountry()
    }


}