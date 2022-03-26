package com.example.retrofitjsonnews.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.retrofitjsonnews.R
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.Date

class DateViewHolder(itemView: View): BaseViewHolder(itemView) {

    private val dateTextView by lazy { itemView.findViewById<TextView>(R.id.dateTV) }

    companion object {
        const val VIEW_TYPE = 1

        fun newInstance(parent: ViewGroup) = DateViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_date,
                parent,
                false
            )
        )
    }

    override fun bindItem(item: BaseItem) {
        (item as Date).apply {
            dateTextView.text = date
        }
    }
}