package com.example.motivese.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivese.R
import com.example.motivese.data.Mock
import com.example.motivese.databinding.ActivityMainBinding
import com.example.motivese.infra.MotivacaoConstants
import com.example.motivese.infra.SecurityPreferences
import com.example.motivese.databinding.ActivityUserBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1 //Inicia com 1 para trazer todos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()

        handleFilter(R.id.image_all)

        handleNextPhrase()

        binding.buttonNewphrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textUserName.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        handleUserName()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_newphrase) {
            handleNextPhrase()
        }else if (view.id in listOf(R.id.image_all, R.id.imageHappy, R.id.imageSunny)){ //Muda os botões e o valor do categoryID
            handleFilter(view.id)
        }else if (view.id == R.id.text_user_name) {
            startActivity(Intent(this,UserActivity::class.java))
        }
    }

    private fun handleNextPhrase(){
        binding.textPhrase.text = Mock().getPhrase(categoryId)
    }

    private fun handleFilter(id : Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivacaoConstants.FILTER.ALL //Muda para 1
            }
            R.id.imageHappy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivacaoConstants.FILTER.HAPPY // Muda para 2
            }
            R.id.imageSunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivacaoConstants.FILTER.SUNNY //Muda para 3
            }
        }
    }

    //Seta nome do usuário
    private fun handleUserName(){
        val name = SecurityPreferences(this).getString(MotivacaoConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, ${name}!"
    }
}