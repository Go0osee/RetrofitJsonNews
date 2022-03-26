package com.example.retrofitjsonnews.presentation.ext

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageByUrl(itemView: View, Url: String?){
    Glide.with(itemView.context)
        .load(Url)
        .into(this)
}