package com.example.retrofitjsonnews.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.Date
import com.example.retrofitjsonnews.domain.model.News
import java.lang.IllegalStateException

class MainAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private var items: List<BaseItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DateViewHolder.VIEW_TYPE -> DateViewHolder.newInstance(parent)
            NewsViewHolder.VIEW_TYPE -> NewsViewHolder.newInstance(parent)
            else -> throw IllegalStateException("Wrong view holder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Date -> DateViewHolder.VIEW_TYPE
            is News -> NewsViewHolder.VIEW_TYPE
            else -> 0
        }
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<BaseItem>) {
        notifyDataSetChanged()
        items = data
    }
}