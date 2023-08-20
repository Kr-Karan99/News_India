package com.example.recycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){
    lateinit var adapter: NewsListAdapter
    private var currentPage = 1
    private var isLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getNews()


    }

    private fun getNews() {
        if (!isLoading) {
            isLoading = true
            val news = NewsService.newsInstance.getHeadlines(country = "in", page = currentPage)
            news.enqueue(object : Callback<News> {

                override fun onFailure(call: Call<News>, t: Throwable) {
                    isLoading = false
                    Log.d("CHEEZYCODE", "ERROR IN FETCHING MESSAGE", t)
                }

                override fun onResponse(call: Call<News>, response: Response<News>) {
                    isLoading = false
                    val news = response.body()
                    if (news != null) {
                        Log.d("CHEEZYCODE", news.toString())

                        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                        val adapter = NewsListAdapter(this@MainActivity, news.articles.toMutableList())
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.adapter = adapter
                        currentPage++


                    }
                }

            })
        }
    }



    // override fun onItemClicked(item: String) {
   //     Toast.makeText(this,"clicked item is $item",Toast.LENGTH_LONG).show()
   // }
}