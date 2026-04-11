package com.mohamedwaleed.dominoscore

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var toolbar : Toolbar
    lateinit var container: LinearLayout
    lateinit var playerViewModel : PlayerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(SystemBarStyle.dark(1))
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }



        playerViewModel = ViewModelProvider(this).get(PlayerViewModel :: class.java)
        container = findViewById(R.id.cards_container)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.add_button){

                if (playerViewModel.playersCounter < 5){
                    playerViewModel.addCard()

                    val playerCardData = playerViewModel.playersList.last()

                    val playerCardView = PlayerCardView(container , layoutInflater)

                    playerCardView.scoreView.text = playerCardData.score.toString()
                    playerCardView.nameView.text = playerCardData.name

                    container.addView(playerCardView.cardView)

                    playerCardView.plusButton.setOnClickListener {
                        playerViewModel.increaseScore(playerCardData)
                        playerCardView.scoreView.text = playerCardData.score.toString()
                    }
                    playerCardView.minusButton.setOnClickListener {
                        playerViewModel.decreaseScore(playerCardData)
                        playerCardView.scoreView.text = playerCardData.score.toString()
                    }
                    playerCardView.deleteButton.setOnClickListener {
                        playerViewModel.removePlayer(playerCardData)
                        container.removeView(playerCardView.cardView)
                    }

                }
                else{
                    Toast.makeText(this , "Reached limit of 5 !" , Toast.LENGTH_SHORT).show()
                }

            }
            return@setOnMenuItemClickListener true
        }

    }
}

