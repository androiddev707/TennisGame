package com.bigbang.tennismnia

import kotlinx.android.synthetic.main.game_fragment_layout.*

object StringUtil {
    fun Int.toMinutes(): String {
        val seconds = this % 60
        val minutes = (this / 60) % 60
        return "$minutes:$seconds"
    }
}