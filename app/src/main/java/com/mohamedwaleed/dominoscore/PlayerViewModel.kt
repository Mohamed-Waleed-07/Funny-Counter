package com.mohamedwaleed.dominoscore

import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {
    private var _playerCounter : Int = 0
    var playerCounter = _playerCounter


    fun addCard(playerCardData: PlayerCardData , playerCardView: PlayerCardView) : PlayerCardView{

        playerCardView.scoreView.text = playerCardData.score.toString()
        playerCardView.nameView.text = playerCardData.name
        playerCardView.setColor()
        playerCardView.plusButton.setOnClickListener { increaseScore(playerCardData , playerCardView) }
        playerCardView.minusButton.setOnClickListener { decreaseScore(playerCardData , playerCardView) }

        playerCounter++
        return playerCardView
    }
    fun increaseScore(playerCardData: PlayerCardData , playerCardView: PlayerCardView){
        playerCardData.incScore()
        playerCardView.scoreView.text = playerCardData.score.toString()
    }
    fun decreaseScore(playerCardData: PlayerCardData , playerCardView: PlayerCardView){
        playerCardData.decScore()
        playerCardView.scoreView.text = playerCardData.score.toString()
    }
    fun removePlayer(){
        playerCounter--
    }

}