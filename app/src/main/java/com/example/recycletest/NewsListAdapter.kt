package com.example.recycletest

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(private val context: Context, private val article: MutableList<Article>?):RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_news,parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {

        return article?.size ?:0
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val article = article?.get(position)
        if (article != null) {
            // Bind data to the view holder
            holder.newsTitle.text=article.title
            holder.newsDescription.text=article.description
            Glide.with(context).load(article.urlToImage).into(holder.newsImage)
            holder.itemView.setOnClickListener {
                Toast.makeText(context,article.title,Toast.LENGTH_SHORT)
                val intent = Intent(context,DetailActivity::class.java)
                intent.putExtra("URL",article.url)
                context.startActivity(intent)
            }
        }
    }
// chat
    fun addNewsList(newNewsList: List<Article>) {
        val startPosition = article?.size
        article?.addAll(newNewsList)
        if (startPosition != null) {
            notifyItemRangeInserted(startPosition, newNewsList.size)
        }
    }
// chat
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        var newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        var newsDescription: TextView = itemView.findViewById(R.id.newsDescription)
    }

}


