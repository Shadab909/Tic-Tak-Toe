package com.example.tictaktoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tictaktoe.databinding.FragmentStartGameBinding


class StartGameFragment : Fragment() {

    private lateinit var binding: FragmentStartGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_start_game, container,false)

        binding.image.translationY = -1000f
        binding.startBtn.translationY = 1000f
        binding.image.animate().translationY(0f).duration = 1000
        binding.startBtn.animate().translationY(0f).duration = 1000

        binding.startBtn.setOnClickListener {
            findNavController().navigate(StartGameFragmentDirections.actionStartGameFragmentToPlayGameFragment())
        }


        return binding.root;
    }


}