package com.example.newsinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsinfo.R
import com.example.newsinfo.adapter.WorldNewsAdapter
import com.example.newsinfo.model.Articles
import com.example.newsinfo.viewmodel.WorldNewsViewModel


class WorldNewsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var articlesList: ArrayList<Articles>
    private lateinit var viewModel: WorldNewsViewModel
    private lateinit var adapter: WorldNewsAdapter
    private lateinit var progressBarNews: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_world_news, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_news)
        progressBarNews = view.findViewById(R.id.progressBar_news)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel = ViewModelProvider(this).get(WorldNewsViewModel::class.java)


        viewModel.getNews("in", 1)
        viewModel.myResponse.observe(viewLifecycleOwner, {
            articlesList = ArrayList()
            for (i in 0 until it.size - 1) {
                articlesList.add(it[i])
            }
            adapter = context?.let { it1 -> WorldNewsAdapter(articlesList, it1) }!!
            recyclerView.adapter = adapter

        })
        viewModel.isLoading.observe(viewLifecycleOwner, {
            if (it == true) {
                progressBarNews.visibility = View.VISIBLE
            } else {
                progressBarNews.visibility = View.GONE
            }
        })
        return view
    }

}