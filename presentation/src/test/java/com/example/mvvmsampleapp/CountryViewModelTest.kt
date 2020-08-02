package com.example.mvvmsampleapp

import com.example.domain.model.CountryUseCaseModel
import com.example.domain.usecase.GetCountryUseCase
import com.example.mvvmsampleapp.country.CountryUiModel
import com.example.mvvmsampleapp.country.CountryViewModel
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class CountryViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    @Mock
    lateinit var mapper : MapperForDomainAndPresenter<CountryUiModel, CountryUseCaseModel>

    @Mock
    lateinit var useCase: GetCountryUseCase

    @InjectMocks
    lateinit var viewModel: CountryViewModel


    @Before
    fun setup() {
        // Sets the given [dispatcher] as an underlying dispatcher of [Dispatchers.Main].
        // All consecutive usages of [Dispatchers.Main] will use given [dispatcher] under the hood.
        MockitoAnnotations.initMocks(this);
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Resets state of the [Dispatchers.Main] to the original main dispatcher.
        // For example, in Android Main thread dispatcher will be set as [Dispatchers.Main].
        Dispatchers.resetMain()

        // Clean up the TestCoroutineDispatcher to make sure no other work is running.
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun testSomething() = runBlocking<Unit> {
        viewModel.getDetails().observeForever { }

        viewModel.getDetails()

        verify(mapper).getPresenterModel(any())

    }
}