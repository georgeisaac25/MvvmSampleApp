package com.example.mvvmsampleapp.country

import android.app.Dialog
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
import com.example.mvvmsampleapp.util.ProgressDialog
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CountryActivity : BaseView<CountryViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var countryAdapter: CountryAdapter

    lateinit var dialog : Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        dialog = ProgressDialog.progressDialog(this)
    }

    override fun onStart() {
        super.onStart()
        observeData(getViewModelInstance())
    }

    override fun getViewModelInstance(): CountryViewModel {
        return ViewModelProviders.of(this, viewModelFactory)
            .get(CountryViewModel::class.java)
    }

    override fun observeData(viewModel: CountryViewModel) {
        viewModel.countryData.observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    countryAdapter.setList(it.data)
                    recyclerView.visibility = View.VISIBLE
                    recyclerView.adapter = countryAdapter
                    dialog.dismiss()
                }
                Status.ERROR -> {
                    dialog.dismiss()
                }
                Status.LOADING -> {
                    dialog.show()
                }
            }
        })
    }


}
