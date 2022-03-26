package com.example.retrofitjsonnews.presentation.ext

import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import com.bumptech.glide.Glide

fun ImageView.setImageByUrl(itemView: View, Url: String?) {
    Glide.with(itemView.context)
        .load(Url)
        .into(this)
}

fun SearchView.setOnQueryListener(click: (String) -> Unit = {}) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            if (query != null) {
                click(query)
            }
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean = false
    })
}