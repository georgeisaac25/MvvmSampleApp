package com.example.mvvmsampleapp.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsampleapp.R

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {

    var listCountry: List<CountryUiModel>? = null

    fun setList(listCountry: List<CountryUiModel>?) {
        this.listCountry = listCountry
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView = itemView.findViewById(R.id.countryName)
        var image: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_country, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val country: CountryUiModel? = listCountry?.get(position)
        holder.countryName.setText(country?.name)

        //setImage(country.flag, holder.image)


    }

    override fun getItemCount(): Int {
        return listCountry!!.size
    }


}