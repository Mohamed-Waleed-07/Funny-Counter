package com.mohamedwaleed.dominoscore

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.graphics.toColorInt

class PlayerCardView(
    container : LinearLayout,
    inflater: LayoutInflater,

) {

      val cardView : View = inflater.inflate(R.layout.card_design , container , false)
     private val actualCard : CardView = cardView.findViewById(R.id.card_design)

     val nameView : TextView = cardView.findViewById(R.id.name_view)
     val scoreView : TextView = cardView.findViewById(R.id.score_view)
     val plusButton : ImageButton = cardView.findViewById(R.id.plus_button)
     val minusButton: ImageButton = cardView.findViewById(R.id.minus_button)
     val deleteButton : ImageButton = cardView.findViewById(R.id.delete_button)

     val color : String=""

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

    fun setColor(){
        val randomColor = colorPalette.random()
        val color = randomColor.toColorInt()
        actualCard.setCardBackgroundColor(color)
    }


}