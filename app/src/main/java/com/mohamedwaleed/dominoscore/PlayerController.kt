package com.mohamedwaleed.dominoscore

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.core.graphics.component3
import androidx.core.graphics.component4
import androidx.core.graphics.toColorInt

class PlayerController(
    player : PlayerCard ,
    container : LinearLayout ,
    inflater: LayoutInflater ,
) {
    val cardView : View = inflater.inflate(R.layout.card_design , container , false)
    val actualCard : CardView = cardView.findViewById(R.id.card_design)

    val nameView : TextView = cardView.findViewById(R.id.name_view)
    val scoreView : TextView = cardView.findViewById(R.id.score_view)
    val plusButton : ImageButton = cardView.findViewById(R.id.plus_button)
    val minusButton: ImageButton = cardView.findViewById(R.id.minus_button)
    val deleteButton : ImageButton = cardView.findViewById(R.id.delete_button)

    fun updateUI(player : PlayerCard){
        nameView.text = player.name
        scoreView.text = player.score.toString()
    }

    fun addColor(){
        // Now this will work perfectly!
        val randomColor = colorPalette.random()
        val convertedColor = randomColor.toColorInt()

        actualCard.setCardBackgroundColor(convertedColor)
    }

    fun removeCard(player : PlayerCard , container: LinearLayout){

        playersList.remove(player)
        container.removeView(cardView)
        playersCount = playersList.size
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
        playersCount = playersList.size

        container.addView(cardView)
    }

    // Put constants like this in a companion object so they are only created once
    companion object {
        val colorPalette = listOf(
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
        var playersCount : Int = 0

        val playersList = mutableListOf<PlayerCard>()
    }

}