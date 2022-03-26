package com.example.retrofitjsonnews.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.retrofitjsonnews.R
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.News

class NewsViewHolder(itemView: View) : BaseViewHolder(itemView) {

    private val newsTitleText by lazy { itemView.findViewById<TextView>(R.id.newsTitleText) }
    private val newsDescription by lazy { itemView.findViewById<TextView>(R.id.newsDescription) }
    private val newsAuthor by lazy { itemView.findViewById<TextView>(R.id.newsAuthor) }
    private val newsImage by lazy { itemView.findViewById<ImageView>(R.id.newsImage) }

    private val rootNews by lazy { itemView.findViewById<ConstraintLayout>(R.id.rootNews) }


    companion object {
        const val VIEW_TYPE = 2

        fun newInstance(parent: ViewGroup) = NewsViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_news,
                parent,
                false
            )
        )
    }

    override fun bindItem(item: BaseItem) {
        (item as News).apply {

            Glide.with(itemView.context)
                .load(previewUrl)
                .into(newsImage)

            newsTitleText.text = title
            newsDescription.text = description
            newsAuthor.text = author
        }
    }
}