package com.metehanbolat.retrofitwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.metehanbolat.retrofitwithdi.di.AppModule
import com.metehanbolat.retrofitwithdi.repository.MainNewsRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var repo = MainNewsRepository(AppModule.provideNewsApi())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}