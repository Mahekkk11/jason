package com.jg.onlinelecture

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WebDemoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_demo)

        val webView: WebView = findViewById(R.id.webView) // Assuming your WebView's ID is webView

        // Enable JavaScript (important for many web pages)
        webView.settings.javaScriptEnabled = true

        // Optional: Handle page navigation within the WebView itself
        webView.webViewClient = WebViewClient()

       // webView.loadData("<html><body><h1>Dynamic HTML</h1><p>This content was generated in Kotlin!</p></body></html>", "text/html", "UTF-8")
        // Load a URL
        webView.loadUrl("https://citycab.live") // Replace with your desired URL

        //Load HTML String
        //webView.loadData(htmlString, "text/html", "UTF-8")

        //Load local HTML file from assets folder
        //webView.loadUrl("file:///android_asset/my_local_page.html")
    }
}