package com.example.kortspel_androidutveckling
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var currentCard = 0  // Kortet som visas just nu
    private var score = 0        // Poäng

    // Element från layouten
    private lateinit var tvCard: TextView
    private lateinit var tvScore: TextView
    private lateinit var btnHigher: MaterialButton
    private lateinit var btnLower: MaterialButton
    private lateinit var btnNewGame: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // Koppla till element i layouten
        tvScore = findViewById(R.id.tvScore)
        tvCard = findViewById(R.id.cardView)  // ändra bara detta om ID:t är annorlunda
        btnHigher = findViewById(R.id.btnHigher)
        btnLower = findViewById(R.id.btnLower)
        btnNewGame = findViewById(R.id.btnNewGame)

        // Starta spelet direkt
        newGame()

        // Knapparna
        btnHigher.setOnClickListener { guess(true) }   // true = gissa större
        btnLower.setOnClickListener { guess(false) }   // false = gissa mindre
        btnNewGame.setOnClickListener { newGame() }
    }

    // Börja ett nytt spel
    private fun newGame() {
        score = 0
        tvScore.text = "Poäng: 0"
        drawCard()
        btnHigher.isEnabled = true
        btnLower.isEnabled = true
    }

    // Dra ett slumpat kort (2 till 14)
    private fun drawCard() {
        currentCard = Random.nextInt(2, 15)  // 2 till 14 (14 = Ess)
        tvCard.text = cardName(currentCard)
    }

    // Gissa större eller mindre
    private fun guess(isHigher: Boolean) {
        val nextCard = Random.nextInt(2, 15)

        tvCard.text = cardName(nextCard)

        val correct = if (isHigher) nextCard > currentCard else nextCard < currentCard

        if (correct) {
            score++
            tvScore.text = "Poäng: $score"
        } else {
            tvCard.text = "Fel!\nPoäng: $score"
            btnHigher.isEnabled = false
            btnLower.isEnabled = false
        }

        currentCard = nextCard
    }

    // Gör nummer till namn (t.ex. 11 = Knekt)
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