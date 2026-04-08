package com.mohamedwaleed.dominoscore

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.graphics.toColorInt

class PlayerController(
    player : PlayerCard ,
    container : LinearLayout ,
    inflater: LayoutInflater ,
) {
    private val cardView : View = inflater.inflate(R.layout.card_design , container , false)
    private val actualCard : CardView = cardView.findViewById(R.id.card_design)

    private val nameView : TextView = cardView.findViewById(R.id.name_view)
    private val scoreView : TextView = cardView.findViewById(R.id.score_view)
    private val plusButton : ImageButton = cardView.findViewById(R.id.plus_button)
    private val minusButton: ImageButton = cardView.findViewById(R.id.minus_button)
    private val deleteButton : ImageButton = cardView.findViewById(R.id.delete_button)

    private fun updateUI(player : PlayerCard){
        nameView.text = player.name
        scoreView.text = player.score.toString()
    }

    private fun addColor(){
        // Now this will work perfectly!
        val randomColor = colorPalette.random()
        val convertedColor = randomColor.toColorInt()

        actualCard.setCardBackgroundColor(convertedColor)
    }

    private fun removeCard(player : PlayerCard , container: LinearLayout){

        playersList.remove(player)
        container.removeView(cardView)
        _playersCount = playersList.size
    }
    // The init block is moved to the bottom, AFTER the functions are ready
    init {


        updateUI(player)
        addColor()

        cardView.tag = player
        plusButton.setOnClickListener {
            player.increase()
            updateUI(player)
        }

        minusButton.setOnClickListener {
            player.decrease()
            updateUI(player)
        }
        deleteButton.setOnClickListener {
            removeCard(player , container)
        }
        playersList.add(player)
        _playersCount = playersList.size

        container.addView(cardView)
    }

    // Put constants like this in a companion object so they are only created once
     companion object {
        private val colorPalette = listOf(
            "#F44336", // Red (Your Original)
            "#E91E63", // Pink
            "#9C27B0", // Purple (Your Original)
            "#673AB7", // Deep Purple
            "#3F51B5", // Indigo
            "#2196F3", // Blue (Your Original)
            "#03A9F4", // Light Blue
            "#00BCD4", // Cyan (Your Original)
            "#009688", // Teal
            "#4CAF50", // Green (Your Original)
            "#8BC34A", // Light Green
            "#CDDC39", // Lime
            "#FFC107", // Amber
            "#FF9800", // Orange (Your Original)
            "#FF5722"  // Deep Orange
        )
        private var _playersCount : Int = 0
        var playersCounter : Int = _playersCount


        private val playersList = mutableListOf<PlayerCard>()
    }

}