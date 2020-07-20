package com.bigbang.tennismnia.model

data class TennisGame(var playerOne: TennisPlayer, var playerTwo: TennisPlayer) {

    fun getGameStatus(): String {
        return when {
            playerOne.gamePoints > playerTwo.gamePoints -> "Player One is leading by ${playerOne.gamePoints - playerTwo.gamePoints} points"
            playerOne.gamePoints > playerTwo.gamePoints -> "Player Two is leading by ${playerOne.gamePoints - playerTwo.gamePoints} points"
            else -> "Game is at a TIE"
        }
    }
}