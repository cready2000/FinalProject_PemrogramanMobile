package com.cready.finalproject.ui.budaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cready.finalproject.R
import kotlinx.android.synthetic.main.budaya_list_item.view.*
import kotlinx.android.synthetic.main.kuliner_list_item.view.*
import kotlinx.android.synthetic.main.wisata_list_item.view.*

class BudayaAdapter (val BudayaItemList: List<BudayaData>, val clickListener: (BudayaData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.budaya_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(BudayaItemList[position], clickListener)
    }

    override fun getItemCount() = BudayaItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(budaya: BudayaData, clickListener: (BudayaData) -> Unit) {
            itemView.BudayaNama.text = budaya.BudayaNama.toString()
            itemView.BudayaPhoto.setImageResource(budaya.BudayaPhoto)
            itemView.setOnClickListener { clickListener(budaya) }
        }
    }
}