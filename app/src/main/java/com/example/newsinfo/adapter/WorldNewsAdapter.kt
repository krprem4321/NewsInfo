package com.example.newsinfo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsinfo.R
import com.example.newsinfo.model.Articles


class WorldNewsAdapter(
    private var articlesList: ArrayList<Articles>,
    private val context: Context
) :
    RecyclerView.Adapter<WorldNewsAdapter.NewsAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.news_item_layout, parent, false)
        return NewsAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        val article = articlesList[position]
        holder.authorName.text = article.author
        holder.titleName.text = article.title
        holder.newsUrl.text = article.url
        holder.descriptionName.text = article.description
        val imageUrl = article.urlToImage

        Glide.with(context).load(imageUrl).placeholder(R.drawable.ic_launcher_foreground).into(holder.newImage)

    }

    override fun getItemCount(): Int = articlesList.size

    inner class NewsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorName: TextView = itemView.findViewById(R.id.authorTxt)
        val titleName: TextView = itemView.findViewById(R.id.titleTxt)
        val descriptionName: TextView = itemView.findViewById(R.id.descriptionTxt)
        val newsUrl: TextView = itemView.findViewById(R.id.url_txt)
        val newImage: ImageView = itemView.findViewById(R.id.news_image)
    }
}
