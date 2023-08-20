package com.example.recycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val url=intent.getStringExtra("URL")
        val detailWebView: WebView = findViewById(R.id.detailWebView)
        if(url!=null){
            detailWebView.settings.javaScriptEnabled=true
            detailWebView.settings.userAgentString="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.190 Safari/537.36"
            detailWebView.webViewClient=object :WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    val progressBar: ProgressBar = findViewById(R.id.progressBar)
                    progressBar.visibility= View.GONE
                    detailWebView.visibility=View.VISIBLE
                }
            }
            detailWebView.loadUrl(url)
        }
    }
}