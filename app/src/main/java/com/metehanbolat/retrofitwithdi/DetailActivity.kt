package com.metehanbolat.retrofitwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.FirebasePerformance
import com.google.firebase.perf.ktx.performance
import com.google.firebase.perf.metrics.Trace
import com.metehanbolat.retrofitwithdi.databinding.ActivityDetailBinding
import com.metehanbolat.retrofitwithdi.viewmodel.DetailActivityViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private var renderingTrace: Trace = Firebase.performance.newTrace("load_trace")
    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        renderingTrace.start()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        viewModel = ViewModelProvider(this)[DetailActivityViewModel::class.java]
        viewModel.viewModelScope.launch {
            delay(3000L)
            setContentView(view)
            renderingTrace.stop()
        }

    }
}