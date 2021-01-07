package com.cready.finalproject.ui.budaya

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cready.finalproject.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.budaya_content_detail.*
import kotlinx.android.synthetic.main.wisata_content_detail.*
import kotlinx.android.synthetic.main.wisata_content_detail.*
import kotlinx.android.synthetic.main.wisata_content_detail.buttonMap
import kotlinx.android.synthetic.main.wisata_content_detail.buttonWeb

class BudayaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.budaya_activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        var intentThatStartedThisActivity = intent
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_COMPONENT_NAME)) {
            putData(intentThatStartedThisActivity)
        }
    }

    private fun putData(intentThatStartedThisActivity : Intent) {
        var photo = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_SPLIT_NAME).toInt()
        var nama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
        var deskripsi= intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EXCLUDE_COMPONENTS)
        var website = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER_NAME)
        BudayaPhotoDetail.setImageResource(photo)
        BudayaNamaDetail.text = nama
        BudayaDeskripsiDetail.text = deskripsi

        buttonWeb.setOnClickListener {
            openWeb(website)
        }
    }

    private fun openWeb(url: String) {
        val showWebActivity = Intent(this, BudayaWebsite::class.java)
        showWebActivity.putExtra(Intent.ACTION_WEB_SEARCH, url)
        startActivity(showWebActivity)
    }
}