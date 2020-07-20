package com.bigbang.tennismnia.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bigbang.tennismnia.R
import com.bigbang.tennismnia.viewmodel.TennisViewModel
import com.bigbang.tennismnia.viewmodel.TennisViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private val gameFragment: GameFragment by lazy { GameFragment() }
    private val tennisViewModel: TennisViewModel by viewModels(factoryProducer = { TennisViewModelFactory })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_game_button.setOnClickListener {
            tennisViewModel.startGame()
            openGameFragment()
        }
    }

    private fun openGameFragment() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            .replace(R.id.game_frame, gameFragment)
            .commit()
    }
}