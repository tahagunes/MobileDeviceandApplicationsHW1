package com.google.codelabs.buildyourfirstmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_page2.*

class Page2 : AppCompatActivity() {
    private lateinit var gelenbilgi : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        gelenbilgi = findViewById(R.id.textView)

        val yazilanbilgi = intent.getStringExtra("deneme")
        gelenbilgi.text= yazilanbilgi




    }
}