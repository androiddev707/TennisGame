package com.bigbang.tennismnia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bigbang.tennismnia.R
import com.bigbang.tennismnia.viewmodel.TennisViewModel
import com.bigbang.tennismnia.viewmodel.TennisViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {


    private val tennisViewModel: TennisViewModel by viewModels(factoryProducer = { TennisViewModelFactory })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_game_button.setOnClickListener {
            tennisViewModel.startGame()
        }
    }
}