package com.example.gamescore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
    lateinit var tvPLayer1points : TextView
    lateinit var tvPLayer2points : TextView
    lateinit var etPLayer1point : EditText
    lateinit var etPLayer2point : EditText
    lateinit var etPLayer3point : EditText
    lateinit var etPLayer4point : EditText
    lateinit var btnAcceptPoints : Button
    var pLayer1point : Int = 0
    var pLayer2point : Int = 0
    val player1PointsSumArray : ArrayList<Int> = ArrayList()
    val player2PointsSumArray : ArrayList<Int> = ArrayList()
    var player1pointSumInt : Int = 0
    var player2pointSumInt : Int = 0

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
        btnAcceptPoints = findViewById(R.id.btn_acceptPlayersPoints)
        etPLayer1point = findViewById(R.id.et_gracz1Points)
        etPLayer2point = findViewById(R.id.et_gracz2Points)
        tvPLayer1points = findViewById(R.id.tv_gracz1Punkty)
        tvPLayer2points = findViewById(R.id.tv_gracz2Punkty)
//        etPLayer3point : EditText
//        etPLayer4point : EditText

        imiona = intent.extras?.getStringArrayList("Imiona") as ArrayList<String>
        ustawImiona(liczbaUczestnikow)
        btnAcceptPoints.setOnClickListener(View.OnClickListener { view -> pobierzPunktyGraczy() })
        Log.d(TAG,liczbaUczestnikow.toString())
        Log.d(TAG, imiona.toString())
        var recyclerView : RecyclerView = findViewById(R.id.rv_Gracz1ListaPuntow)
        var recyclerView2 : RecyclerView = findViewById(R.id.rv_Gracz2ListaPuntow)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = MyAdapter(player1PointsSumArray)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.itemAnimator = DefaultItemAnimator()
        recyclerView2.adapter = MyAdapter2(player2PointsSumArray)

    }

    override fun onStop() {
        super.onStop()
        TODO()
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
    fun pobierzPunktyGraczy(){
        if(etPLayer1point!=null&&etPLayer2point!=null){
            pLayer1point = etPLayer1point.text.toString().toInt()
            pLayer2point = etPLayer2point.text.toString().toInt()
            player1PointsSumArray.add(pLayer1point)
            player2PointsSumArray.add(pLayer2point)
            player1pointSumInt+=pLayer1point
            player2pointSumInt+=pLayer2point
        }
        else if (etPLayer1point==null&&etPLayer2point!=null){
            pLayer1point=0
            pLayer2point = etPLayer2point.text.toString().toInt()
            player1PointsSumArray.add(pLayer1point)
            player2PointsSumArray.add(pLayer2point)
            player1pointSumInt+=pLayer1point
            player2pointSumInt+=pLayer2point
        }
        else if(etPLayer1point!=null&&etPLayer2point==null){
            pLayer1point=etPLayer1point.text.toString().toInt()
            pLayer2point=0
            player1PointsSumArray.add(pLayer1point)
            player2PointsSumArray.add(pLayer2point)
            player1pointSumInt+=pLayer1point
            player2pointSumInt+=pLayer2point
        }
        else{
            var toast : Toast
            toast = Toast.makeText(this,"Błąd pobierania danych",Toast.LENGTH_SHORT)
        }
        tvPLayer1points.text = player1pointSumInt.toString()
        tvPLayer2points.text = player2pointSumInt.toString()
    }
}