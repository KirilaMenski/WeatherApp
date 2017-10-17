package com.ansgar.kotlinweatherapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ansgar.kotlinweatherapp.model.CityModel

import java.lang.ref.WeakReference
import java.util.ArrayList

/**
 * Created by kirill on 17.10.17.
 */

class Adapter(cityModels: List<CityModel>, private val mListener: AdapterListener, context: Context)
    : RecyclerView.Adapter<Adapter.AdapterHolder>() {

    private var cityModels: List<CityModel> = ArrayList()
    private val mContext: WeakReference<Context>

    init {
        this.cityModels = cityModels
        mContext = WeakReference(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val inflater = LayoutInflater.from(mContext.get())
        val view = inflater.inflate(R.layout.item_city, parent, false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val cityModel = cityModels[position]

    }

    override fun getItemCount(): Int {
        return cityModels.size
    }

    inner class AdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(model: CityModel) {

        }
    }

    interface AdapterListener {
        fun itemSelected(id: Int)
    }

}
