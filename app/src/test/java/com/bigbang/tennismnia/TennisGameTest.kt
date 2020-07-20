package com.bigbang.tennismnia

import com.bigbang.tennismnia.model.TennisGame
import com.bigbang.tennismnia.model.TennisPlayer
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TennisGameTest {
    private val tennisPlayer1 = TennisPlayer("Player One", 0)
    private val tennisPlayer2 = TennisPlayer("Player Two", 0)
    private val tennisGame = TennisGame(tennisPlayer1, tennisPlayer2)

    @Test
    fun `test initial state of game, Make sure score is initially zero`() {
        assertEquals(tennisGame.getGameStatus(), "Game is at a TIE")

        assertEquals(tennisGame.playerOne.gamePoints, 0)
        assertEquals(tennisGame.playerTwo.gamePoints, 0)

        assertNotEquals(tennisGame.playerOne.gamePoints, 1)
        assertNotEquals(tennisGame.playerTwo.gamePoints, 1)
    }

    @Test
    fun `test on game scoring system`() {

        assertNotEquals("", tennisGame.getGameStatus())
        assertEquals("Game is at a TIE", tennisGame.getGameStatus())

        //Add Points to player one
        tennisGame.playerOne.gamePoints++
        assertEquals(
            "Player One is leading by ${tennisGame.playerOne.gamePoints - tennisGame.playerTwo.gamePoints} points",
            tennisGame.getGameStatus()
        )

        //Make the game tie
        tennisGame.playerTwo.gamePoints++
        assertEquals(
            "Game is at a TIE",
            tennisGame.getGameStatus()
        )


        //put player two in the lead
        tennisGame.playerTwo.gamePoints++
        assertEquals(
            "Player Two is leading by ${tennisGame.playerOne.gamePoints - tennisGame.playerTwo.gamePoints} points",
            tennisGame.getGameStatus()
        )
    }

}