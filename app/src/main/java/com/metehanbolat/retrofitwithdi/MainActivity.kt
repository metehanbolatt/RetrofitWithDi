package com.metehanbolat.retrofitwithdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.FirebasePerformance
import com.google.firebase.perf.ktx.performance
import com.google.firebase.perf.metrics.Trace
import com.metehanbolat.retrofitwithdi.databinding.ActivityMainBinding
import com.metehanbolat.retrofitwithdi.model.Article
import com.metehanbolat.retrofitwithdi.model.NewsModel
import com.metehanbolat.retrofitwithdi.util.Resource
import com.metehanbolat.retrofitwithdi.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var newsList = emptyList<Article>()

    private lateinit var trace: Trace

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        trace = Firebase.performance.newTrace("get_news_trace")

        viewModel.viewModelScope.launch(Dispatchers.IO) {
            trace.start()
            delay(2000L)
            newsList = viewModel.getNews().data!!.articles
            withContext(Dispatchers.Main) {
                binding.text.text = newsList[5].content
                trace.stop()
            }
        }

        binding.button.setOnClickListener {
            Intent(baseContext, DetailActivity::class.java).apply {
                startActivity(this)
            }
        }

        object: CountDownTimer(5000, 1) {
            override fun onTick(p0: Long) {
                println(p0.toString())
            }
            override fun onFinish() {
                println("Bitti")
            }
        }.start()

    }

}