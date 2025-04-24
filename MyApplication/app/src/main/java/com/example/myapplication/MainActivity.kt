package com.example.myapplication

import android.annotation.SuppressLint
import android.net.http.SslError
import android.os.Bundle
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                binding.progress.visibility = View.GONE
                binding.txtLoading.visibility = View.GONE
                binding.webview.visibility = View.VISIBLE
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(this@MainActivity,"Please check your Internet Connection...!",Toast.LENGTH_LONG).show()
            }

            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                // Show error toast
            }
        }

       // binding.webview.loadUrl("http://google.co.in/")

        binding.webview.loadUrl("https://retailstore4u.com/")
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.settings.domStorageEnabled = true;
        binding.webview.settings.loadsImagesAutomatically = true;
        binding.webview.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW;
    }
}