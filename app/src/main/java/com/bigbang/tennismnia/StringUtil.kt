package com.bigbang.tennismnia

object StringUtil {
    fun Int.toMinutes(): String {
        val seconds = this % 60
        val minutes = (this / 60) % 60
        return "$minutes:$seconds"
    }
}