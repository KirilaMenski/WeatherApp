package com.ansgar.kotlinweatherapp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.model.CityModel
import com.vicpin.krealmextensions.save
import kotlinx.android.synthetic.main.item_city.view.*
import java.lang.ref.WeakReference

/**
 * Created by kirill on 17.10.17.
 */
class CityListAdapter(private var cityModels: List<CityModel>, context: Context) :
        RecyclerView.Adapter<CityListAdapter.CityListHolder>() {

    private val mContext: WeakReference<Context> = WeakReference(context)

    override fun getItemCount(): Int = cityModels.size

    override fun onBindViewHolder(holder: CityListHolder?, position: Int) {
        val cityModel = cityModels[position]
        holder?.bindHolder(cityModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CityListHolder {
        val inflater = LayoutInflater.from(mContext.get())
        val view = inflater.inflate(R.layout.item_city, parent, false)
        return CityListHolder(view)
    }


    class CityListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindHolder(cityModel: CityModel) = with(itemView) {
            city_id.text = cityModel.id.toString()
            city_name.text = cityModel.name
            latitude.text = cityModel.latitude.toString()
            longitude.text = cityModel.longitude.toString()

            item_city_container.setOnClickListener { cityModel.save() }

        }

    }
}