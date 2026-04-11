package com.mohamedwaleed.dominoscore

class PlayerCardData(){
    var score : Int = 0
    val name : String = animalNames.random()

    companion object {

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
    fun incScore(){
        score++
    }
    fun decScore(){
        score--
    }

}
