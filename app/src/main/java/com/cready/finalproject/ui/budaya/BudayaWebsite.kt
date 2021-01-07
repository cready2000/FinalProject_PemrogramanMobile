package com.cready.finalproject.ui.budaya

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cready.finalproject.R
import kotlinx.android.synthetic.main.budaya_website.*

class BudayaWebsite : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.budaya_website)
        val webView = findViewById<WebView>(R.id.citytourWebsite)
        actionBar?.setDisplayHomeAsUpEnabled(false)
        var intentThatStartedThisActivity = intent

        if(intentThatStartedThisActivity.hasExtra(Intent.ACTION_WEB_SEARCH)) {
            var budayaWebsite = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_WEB_SEARCH)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = object  : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    if (view != null) {
                        view.loadUrl("javascript:alert('Load Selesai')")
                    } } }
            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    Toast.makeText(this@BudayaWebsite, message, Toast.LENGTH_LONG).show()
                    if (result != null) {
                        result.confirm() }
                    return true
                } }
            webView.loadUrl(budayaWebsite)
        } else {
        }
    }
}