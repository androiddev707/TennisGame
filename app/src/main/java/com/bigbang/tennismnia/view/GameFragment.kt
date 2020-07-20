package com.bigbang.tennismnia.view

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bigbang.tennismnia.R
import com.bigbang.tennismnia.model.TennisPlayer
import com.bigbang.tennismnia.viewmodel.TennisViewModel
import com.bigbang.tennismnia.viewmodel.TennisViewModelFactory
import kotlinx.android.synthetic.main.game_fragment_layout.*

class GameFragment : Fragment() {

    private var gameTime = 0
    private val tennisViewModel: TennisViewModel by viewModels(factoryProducer = { TennisViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.game_fragment_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                updateTimer()
                handler.postDelayed(this, 1000)
            }
        }, 0)

        tennisViewModel.getGameData().observe(viewLifecycleOwner, Observer { tennisGame ->
            lead_player_text.text = tennisGame.getGameStatus()
            player_one_score_textview.text = tennisGame.playerOne.getScore()
            player_two_score_textview.text = tennisGame.playerTwo.getScore()

            player_one_button.setOnClickListener { view ->
                if (tennisGame.gameTurn.getAndSet(1) == 0) {
                    tennisGame.playerOne.gamePoints++
                    lead_player_text.text = tennisGame.getGameStatus()
                    player_one_score_textview.text = tennisGame.playerOne.getScore()

                    if (tennisGame.playerOne.gamePoints == 4)
                        showGameWonDialog(tennisGame.playerOne)
                } else
                    matchTurnToast()
            }

            player_two_button.setOnClickListener { view ->
                if (tennisGame.gameTurn.getAndSet(0) == 1) {
                    tennisGame.playerTwo.gamePoints++
                    lead_player_text.text = tennisGame.getGameStatus()
                    player_two_score_textview.text = tennisGame.playerTwo.getScore()


                    if (tennisGame.playerTwo.gamePoints == 4)
                        showGameWonDialog(tennisGame.playerTwo)
                } else
                    matchTurnToast()
            }
        })
    }

    private fun matchTurnToast() {
        Toast.makeText(context, "It is not your turn", Toast.LENGTH_SHORT).show()
    }

    private fun updateTimer() {
        gameTime++
        val seconds = gameTime % 60
        val minutes = (gameTime / 60) % 60
        game_timer_textview.text = "$minutes:$seconds"
    }

    private fun showGameWonDialog(winner: TennisPlayer) {
        AlertDialog.Builder(ContextThemeWrapper(context, R.style.AppTheme))
            .setTitle(getString(R.string.winner_title))
            .setMessage(getString(R.string.won_the_game, winner.playerName))
            .create()
            .show()
    }

}