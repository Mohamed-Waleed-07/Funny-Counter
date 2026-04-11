package com.mohamedwaleed.dominoscore

import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {
    val playersList = mutableListOf<PlayerCardData>()
    var playersCounter : Int =0


    fun addCard(){
       playersList.add(PlayerCardData())
       playersCounter = playersList.size
    }
    fun increaseScore(playerCardData: PlayerCardData){
        playerCardData.incScore()
    }
    fun decreaseScore(playerCardData: PlayerCardData){
        playerCardData.decScore()
    }
    fun removePlayer(playerCardData: PlayerCardData){
       playersList.remove(playerCardData)
        playersCounter = playersList.size
    }

}