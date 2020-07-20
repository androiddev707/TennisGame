package com.bigbang.tennismnia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bigbang.tennismnia.model.TennisGame
import com.bigbang.tennismnia.model.TennisRepository

class TennisViewModel : ViewModel() {

    fun getGameData(): LiveData<TennisGame> = TennisRepository.getGameData()
    fun startGame() {
        TennisRepository.startGame()
    }

}