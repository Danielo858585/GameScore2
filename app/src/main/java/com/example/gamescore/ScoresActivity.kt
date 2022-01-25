package com.example.gamescore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.logging.Logger

class ScoresActivity : AppCompatActivity() {
    lateinit var imiona : ArrayList<String>
    var liczbaUczestnikow : Int = 0
    final var TAG : String = "ScoresActivity SPRAWDZENIE"

    var gracz : Int = R.layout.activity_scores
    var gracz2 : Int = R.layout.activity_scores2
    var gracz3: Int = R.layout.activity_scores3
    var graczWybor: Int = 0
    lateinit var tvPLayer1 : TextView
    lateinit var tvPLayer2 : TextView
    lateinit var tvPLayer3 : TextView
    lateinit var tvPLayer4 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent = getIntent()
        liczbaUczestnikow = intent.getIntExtra("Ilosc graczy",0)
        when(liczbaUczestnikow){
            2-> graczWybor = gracz
            3-> graczWybor = gracz2
            else-> graczWybor = gracz3
        }
        setContentView(graczWybor)
        imiona = intent.extras?.getStringArrayList("Imiona") as ArrayList<String>
        ustawImiona(liczbaUczestnikow)
        Log.d(TAG,liczbaUczestnikow.toString())
        Log.d(TAG, imiona.toString())
        var recyclerView : RecyclerView = findViewById(R.id.rv_Gracz1ListaPuntow)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = MyAdapter()




    }
    fun ustawImiona(ilosc : Int){
        when(ilosc){
            2-> {
                tvPLayer1 = findViewById(R.id.tv_imie1)
                tvPLayer2 = findViewById(R.id.tv_imie2)
                tvPLayer1.text = imiona[0]
                tvPLayer2.text = imiona[1]
            }
            3 -> {
                tvPLayer1 = findViewById(R.id.tv_imie1)
                tvPLayer2 = findViewById(R.id.tv_imie2)
                tvPLayer3 = findViewById(R.id.tv_imie3)

                tvPLayer1.text = imiona[0]
                tvPLayer2.text = imiona[1]
                tvPLayer3.text = imiona[2]
            }
            else-> {
                tvPLayer1 = findViewById(R.id.tv_imie1)
                tvPLayer2 = findViewById(R.id.tv_imie2)
                tvPLayer3 = findViewById(R.id.tv_imie3)
                tvPLayer4 = findViewById(R.id.tv_imie4)
                tvPLayer1.text = imiona[0]
                tvPLayer2.text = imiona[1]
                tvPLayer3.text = imiona[2]
                tvPLayer4.text = imiona[3]

            }
        }
    }
}