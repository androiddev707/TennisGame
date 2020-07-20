package com.bigbang.tennismnia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bigbang.tennismnia.model.TennisRepository

object TennisViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TennisViewModel(TennisRepository) as T
    }
}