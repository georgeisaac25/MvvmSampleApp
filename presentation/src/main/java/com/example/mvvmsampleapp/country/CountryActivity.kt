package com.example.mvvmsampleapp.country

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.resultmapper.Status
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.base.BaseView
import com.example.mvvmsampleapp.util.EspressoIdlingResouce
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

        recyclerView.visibility = View.VISIBLE
        recyclerView.adapter = countryAdapter




        dialog = ProgressDialog.progressDialog(this)
        observeData(getViewModelInstance())

    }

    override fun onStart() {
        super.onStart()
    }

    override fun getViewModelInstance(): CountryViewModel {
        return ViewModelProviders.of(this, viewModelFactory)
            .get(CountryViewModel::class.java)
    }

    override fun observeData(viewModel: CountryViewModel) {



        // NOTE : Must observe livedata variable and
        // not a method because VM only retains the variables
        viewModel.countryData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.e("Success","SUccess")
                    countryAdapter.setList(it.data)
                    countryAdapter.notifyDataSetChanged()
                    EspressoIdlingResouce.decrement()
                    dialog.dismiss()
                }
                Status.ERROR -> {
                    dialog.dismiss()
                    Toast.makeText(this@CountryActivity,"Something went wrong",Toast.LENGTH_LONG).show()
                    EspressoIdlingResouce.decrement()
                }
                Status.LOADING -> {
                    EspressoIdlingResouce.increment();
                    dialog.show()
                }
            }
        })
    }


}
