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

class MainActivity : AppCompatActivity() {
    lateinit var toolbar : Toolbar
    lateinit var container: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(SystemBarStyle.dark(1))
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
        container = findViewById(R.id.cards_container)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.add_button){
                if (PlayerController.playersCounter == 5){
                    Toast.makeText(this@MainActivity , "Limit is 5 players !" , Toast.LENGTH_LONG).show()
                }
                else{
                    val controller = PlayerController(
                        PlayerCard(), container, layoutInflater)
                }

            }
            return@setOnMenuItemClickListener true
        }
    }
}

