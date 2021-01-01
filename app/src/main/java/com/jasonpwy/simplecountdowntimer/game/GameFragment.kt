package com.jasonpwy.simplecountdowntimer.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jasonpwy.simplecountdowntimer.R
import com.jasonpwy.simplecountdowntimer.databinding.GameFragmentBinding


class GameFragment : Fragment() {

    private lateinit var viewModel : GameViewModel

    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.lifecycleOwner = this
        binding.gameViewModel = viewModel

        val adapter = GameAdapter()
        binding.recyclerView.adapter = adapter

        binding.submitBtn.setOnClickListener {
            viewModel.addText(binding.activityName.text.toString())
        }

        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = linearLayoutManager

        viewModel.ListData.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })
        return binding.root
    }
}