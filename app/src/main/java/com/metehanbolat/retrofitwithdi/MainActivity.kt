package com.metehanbolat.retrofitwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.metehanbolat.retrofitwithdi.databinding.ActivityMainBinding
import com.metehanbolat.retrofitwithdi.model.NewsModel
import com.metehanbolat.retrofitwithdi.util.Resource
import com.metehanbolat.retrofitwithdi.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.mutableNews.observe(this) {
            println(it)
        }

        object: CountDownTimer(1000, 1) {
            override fun onTick(p0: Long) {
                println(p0.toString())
            }
            override fun onFinish() {
                println("Bitti")
            }
        }.start()

        binding.apply {
            button.setOnClickListener {

            }
        }

    }
}