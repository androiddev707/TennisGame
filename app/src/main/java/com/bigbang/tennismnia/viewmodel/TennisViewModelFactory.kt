package com.bigbang.tennismnia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bigbang.tennismnia.model.TennisRepository

object TennisViewModelFactory : ViewModelProvider.Factory {

    private val tennisViewModel: TennisViewModel = TennisViewModel(TennisRepository)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return tennisViewModel as T
    }
}