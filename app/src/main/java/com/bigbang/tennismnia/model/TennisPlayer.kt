package com.bigbang.tennismnia.model

data class TennisPlayer(var playerName: String = "", var gamePoints: Int = 0) {
    fun getScore(): String {
        return when (gamePoints) {
            0 -> "LOVE"
            1 -> "15"
            2 -> "30"
            3 -> "40"
            else -> "GAME"
        }
    }
}