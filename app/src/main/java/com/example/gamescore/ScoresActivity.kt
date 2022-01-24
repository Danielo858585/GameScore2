package com.example.gamescore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.logging.Logger

class ScoresActivity : AppCompatActivity() {
    lateinit var imiona : ArrayList<String>
    var liczbaUczestnikow : Int = 0
    final var TAG : String = "ScoresActivity SPRAWDZENIE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
        var intent = getIntent()
        imiona = intent.extras?.getStringArrayList("Imiona") as ArrayList<String>
        liczbaUczestnikow = intent.getIntExtra("Ilosc graczy",0)
        Log.d(TAG,liczbaUczestnikow.toString())
        Log.d(TAG, imiona.toString())


    }
}