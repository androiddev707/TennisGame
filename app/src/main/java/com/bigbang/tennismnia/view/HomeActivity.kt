package com.bigbang.tennismnia.view

import android.os.Bundle
import android.view.View
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
            start_game_button.visibility = View.GONE
            new_game_textview.visibility = View.GONE
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
            .add(R.id.game_frame, gameFragment)
            .commit()
    }

    fun closeGame() {

        supportFragmentManager.beginTransaction()
            .remove(gameFragment)
            .commit()
        start_game_button.visibility = View.VISIBLE
        new_game_textview.visibility = View.VISIBLE
    }
}