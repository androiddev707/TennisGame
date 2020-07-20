package com.bigbang.tennismnia.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bigbang.tennismnia.R
import com.bigbang.tennismnia.viewmodel.TennisViewModel
import com.bigbang.tennismnia.viewmodel.TennisViewModelFactory

class GameFragment : Fragment() {

    private val tennisViewModel: TennisViewModel by viewModels(factoryProducer = { TennisViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.game_fragment_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tennisViewModel.getGameData().observe(viewLifecycleOwner, Observer {
            it.let {

            }
        })
    }
}