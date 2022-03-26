package com.example.retrofitjsonnews.presentation

import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitjsonnews.R
import com.example.retrofitjsonnews.presentation.recycler.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter by lazy { MainAdapter() }

    private val recycler by lazy { findViewById<RecyclerView>(R.id.recycler) }
    private val searchEditText by lazy { findViewById<SearchView>(R.id.searchEditText) }
    private val numberOfResult by lazy { findViewById<TextView>(R.id.numberOfResult) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        searchEditText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    search(query)
                    initViews()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//                if (newText != null) {
//                    search(newText)
//                    initViews()
//                }
                return false
            }
        })
    }

    fun initViews() {
        recycler.adapter = adapter

        viewModel.news.observe(this) { items ->
            adapter.submitList(items.news)

            numberOfResult.text = "Количество результатов: " + items.count
        }
    }

    fun search(searchWord: String) {
        viewModel.searchNews(searchWord)
    }
}