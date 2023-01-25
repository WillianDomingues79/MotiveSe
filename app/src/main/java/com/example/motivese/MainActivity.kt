package com.example.motivese

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivese.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindind = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindind.root)

        supportActionBar?.hide()

        bindind.buttonNewphrase.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }
}