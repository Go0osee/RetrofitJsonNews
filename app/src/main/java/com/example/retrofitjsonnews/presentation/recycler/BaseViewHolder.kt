package com.example.retrofitjsonnews.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitjsonnews.domain.model.BaseItem

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindItem(item: BaseItem)
}