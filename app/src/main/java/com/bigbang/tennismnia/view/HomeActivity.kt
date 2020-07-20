package com.bigbang.tennismnia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bigbang.tennismnia.R
import com.bigbang.tennismnia.viewmodel.TennisViewModel
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {


    private lateinit var tennisViewModel: TennisViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tennisViewModel = ViewModelProvider

        start_game_button.setOnClickListener {


        }
    }
}