package com.mohamedwaleed.dominoscore

    class PlayerCard{
    init {
        playersCounter++
    }
        val id : Int = playersCounter
     var score : Int = 0
      var name : String =""
        init {
            name = animalNames.random()
        }
    private companion object {
        var playersCounter : Int = 0
        val animalNames = listOf(
            "Lion",
            "Tiger",
            "Elephant",
            "Giraffe",
            "Zebra",
            "Kangaroo",
            "Penguin",
            "Dolphin",
            "Cheetah",
            "Rhinoceros",
            "Hippopotamus",
            "Wolf",
            "Fox",
            "Eagle",
            "Bear"
        )
    }


    fun increase(){
        score++
    }
    fun decrease(){
        score--
    }




}
