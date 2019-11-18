package com.example.mvvmsampleapp.country

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.responsemapper.Status
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.base.BaseView
import javax.inject.Inject

class CountryActivity : BaseView<CountryViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var recyclerView: RecyclerView
    lateinit var countryAdapter: CountryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    override fun onStart() {
        super.onStart()
        observeData(getViewModelInstance())
    }

    override fun getViewModelInstance(): CountryViewModel {
        return  ViewModelProviders.of(this, viewModelFactory)
            .get(CountryViewModel::class.java)
    }

    override fun observeData(viewModel: CountryViewModel) {
        viewModel.countryData.observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    countryAdapter = CountryAdapter(it.data)
                    recyclerView.visibility = View.VISIBLE
                    recyclerView.adapter = countryAdapter
                }
                Status.ERROR -> {
                    //Handle error
                }
            }
        })
    }


}
