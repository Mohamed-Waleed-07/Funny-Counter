package com.mohamedwaleed.dominoscore

    class PlayerCard{


      var score : Int = 0
      var name : String =""

    private companion object {

        private val animalNames = listOf(
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
        init {
            name = animalNames.random()
        }

        fun increase(){
        score++
    }
        fun decrease(){
        score--
    }




}
