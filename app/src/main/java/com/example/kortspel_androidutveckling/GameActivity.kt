package com.example.kortspel_androidutveckling

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.cardview.widget.CardView
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var currentCard = 0  // Det kort som visas just nu (2-14)
    private var score = 0        // Poäng

    // Element från layouten
    private lateinit var tvCardText: TextView     // NY: Text inuti kortet
    private lateinit var tvScore: TextView
    private lateinit var cardView: CardView       // Din CardView
    private lateinit var btnHigher: MaterialButton
    private lateinit var btnLower: MaterialButton
    private lateinit var btnNewGame: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // Koppla till elementen i layouten
        tvScore = findViewById(R.id.tvScore)
        cardView = findViewById(R.id.cardView)              // Din CardView
        tvCardText = findViewById(R.id.tvCardText)          // NY: TextView inuti CardView
        btnHigher = findViewById(R.id.btnHigher)
        btnLower = findViewById(R.id.btnLower)
        btnNewGame = findViewById(R.id.btnNewGame)

        // Starta ett nytt spel direkt
        newGame()

        // Klicklyssnare
        btnHigher.setOnClickListener { guess(true) }   // Gissa större
        btnLower.setOnClickListener { guess(false) }   // Gissa mindre
        btnNewGame.setOnClickListener { newGame() }
    }

    // Börja om spelet
    private fun newGame() {
        score = 0
        tvScore.text = "Poäng: 0"
        btnHigher.isEnabled = true
        btnLower.isEnabled = true
        drawCard()
    }

    // Dra ett nytt slumpmässigt kort och visa det
    private fun drawCard() {
        currentCard = Random.nextInt(2, 15)  // 2 till 14 (14 = Ess)
        tvCardText.text = cardName(currentCard)
    }

    // Hantera gissning
    private fun guess(isHigher: Boolean) {
        val nextCard = Random.nextInt(2, 15)

        // Kolla om gissningen var rätt
        val correct = if (isHigher) {
            nextCard > currentCard
        } else {
            nextCard < currentCard
        }

        // Om det blir lika – räknas som fel
        if (nextCard == currentCard || !correct) {
            // Fel gissning → game over
            btnHigher.isEnabled = false
            btnLower.isEnabled = false
            tvCardText.text = "Fel!\n${cardName(nextCard)}"
        } else {
            // Rätt gissning → poäng +1
            score++
            tvScore.text = "Poäng: $score"
            currentCard = nextCard
            tvCardText.text = cardName(nextCard)
        }
    }

    // Konvertera nummer till kortnamn
    private fun cardName(value: Int): String {
        return when (value) {
            11 -> "Knekt"
            12 -> "Dam"
            13 -> "Kung"
            14 -> "Ess"
            else -> value.toString()
        }
    }
}