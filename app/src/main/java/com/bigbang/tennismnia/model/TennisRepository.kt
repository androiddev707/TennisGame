package com.bigbang.tennismnia.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object TennisRepository {

    private lateinit var gameInstance: TennisGame
    private val gameState: MutableLiveData<TennisGame> = MutableLiveData()

    fun getGameData(): LiveData<TennisGame> {
        return gameState
    }

    fun startGame() {
        gameInstance = TennisGame(TennisPlayer("PlayerOne", 0), TennisPlayer("PlayerOne", 0))
        gameState.value = gameInstance
    }

}