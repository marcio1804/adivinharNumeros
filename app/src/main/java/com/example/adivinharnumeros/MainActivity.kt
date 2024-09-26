package com.example.adivinharnumeros

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var editTextGuess: EditText
    private lateinit var buttonCheck: Button
    private lateinit var textViewResult: TextView
    private var randomNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextGuess = findViewById(R.id.editTextGuess)
        buttonCheck = findViewById(R.id.buttonCheck)
        textViewResult = findViewById(R.id.textViewResult)

        gerarNumeroAleatorio()

        buttonCheck.setOnClickListener { verificarPalpite() }
    }

    private fun gerarNumeroAleatorio() {
        randomNumber = Random.nextInt(1, 101)
    }

    private fun verificarPalpite() {
        val guessString = editTextGuess.text.toString()

        if (guessString.isNotEmpty()) {
            val guess = guessString.toIntOrNull()
            if (guess != null) {
                when {
                    guess < randomNumber -> textViewResult.text = "Seu palpite é muito baixo."
                    guess > randomNumber -> textViewResult.text = "Seu palpite é muito alto."
                    else -> textViewResult.text = "Parabéns! Você acertou!"
                }
            } else {
                textViewResult.text = "Por favor, insira um número válido."
            }
        } else {
            textViewResult.text = "Por favor, insira um número."
        }
    }
}
