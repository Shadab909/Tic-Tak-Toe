package com.example.tictaktoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tictaktoe.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_result,container,false)

        val arguments = ResultFragmentArgs.fromBundle(requireArguments())
        if (arguments.winner == 1){
            binding.winnerText.text = "Player X Won !!"
        }else if(arguments.winner == 2){
            binding.winnerText.text = "Player O Won !!"
        }
        binding.playAgainBtn.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToPlayGameFragment())
        }

        return binding.root
    }


}