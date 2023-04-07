package com.example.tictaktoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tictaktoe.databinding.FragmentGamePlayBinding
import java.util.logging.XMLFormatter


class PlayGameFragment : Fragment() {
    private lateinit var binding : FragmentGamePlayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_play,container,false)

        binding.btn1.setOnClickListener {
            onClick(binding.btn1)
        }
        binding.btn2.setOnClickListener {
            onClick(binding.btn2)
        }
        binding.btn3.setOnClickListener {
            onClick(binding.btn3)
        }
        binding.btn4.setOnClickListener {
            onClick(binding.btn4)
        }
        binding.btn5.setOnClickListener {
            onClick(binding.btn5)
        }
        binding.btn6.setOnClickListener {
            onClick(binding.btn6)
        }
        binding.btn7.setOnClickListener {
            onClick(binding.btn7)
        }
        binding.btn8.setOnClickListener {
            onClick(binding.btn8)
        }
        binding.btn9.setOnClickListener {
            onClick(binding.btn9)
        }

        return binding.root
    }

    private fun onClick(view : View){
        var cellId = 0;
        val btnSelected = view as Button
        when(btnSelected.id){
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }
        playGame(cellId,btnSelected)
    }

    var currentPlayer = 1
    val player1 = ArrayList<Int>()
    val player2 = ArrayList<Int>()
    var winner = -1
    var isGameOver = false

    fun playGame(cellId : Int , btnSelected : Button){
        if (currentPlayer == 1){
            btnSelected.setBackgroundResource(R.drawable.player_one_box)
            btnSelected.text = "X"
            player1.add(cellId)
            currentPlayer = 2
        }else if(currentPlayer == 2){
            btnSelected.setBackgroundResource(R.drawable.player_two_box)
            btnSelected.text = "O"
            player2.add(cellId)
            currentPlayer = 1
        }

        //row1
        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //row 2
        if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //row 3
        if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //column1
        if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //column 2
        if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //column 3
        if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //diagonal1
        if (player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

        //diagonal2
        if (player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner = 1
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }else if (player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner = 2
            isGameOver = true
            makeNavigation(winner,isGameOver)
            isGameOver = false
        }

    }

    fun makeNavigation(winner : Int , isGameOver : Boolean){
        if (isGameOver){
            findNavController().navigate(PlayGameFragmentDirections.actionPlayGameFragmentToResultFragment(winner))
        }

    }


}