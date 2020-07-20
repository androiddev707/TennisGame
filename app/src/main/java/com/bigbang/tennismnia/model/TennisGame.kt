package com.bigbang.tennismnia.model

import java.util.concurrent.atomic.AtomicInteger

open class TennisGame(var playerOne: TennisPlayer, var playerTwo: TennisPlayer) {

    var gameTurn: AtomicInteger = AtomicInteger(0)

    fun getGameStatus(): String {
        return when {
            playerOne.gamePoints > playerTwo.gamePoints -> "Player One is leading by ${playerOne.gamePoints - playerTwo.gamePoints} points"
            playerTwo.gamePoints > playerOne.gamePoints -> "Player Two is leading by ${playerTwo.gamePoints - playerOne.gamePoints} points"
            else -> "Game is at a TIE"
        }
    }

}