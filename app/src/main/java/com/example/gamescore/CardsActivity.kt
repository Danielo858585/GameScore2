package com.example.gamescore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnFocusChangeListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class CardsActivity : AppCompatActivity() {
    lateinit var imie : String
    lateinit var liczbaGraczy : EditText
    lateinit var etGracz1 : EditText
    lateinit var etGracz2 : EditText
    lateinit var etGracz3 : EditText
    lateinit var etGracz4 : EditText
    var liczbaGraczyInt : Int? = 0
    lateinit var liczba :Number
    lateinit var view : View
    lateinit var zatwierdz: Button
    lateinit var imionaGraczyZatwierdz: Button
    var listaImion : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        liczbaGraczy = findViewById(R.id.etn_liczbaGraczy)
        zatwierdz = findViewById(R.id.btn_numberPlayers)
        imionaGraczyZatwierdz = findViewById(R.id.btn_acceptNames)
        etGracz1 = findViewById(R.id.etn_gracz1)
        etGracz2 = findViewById(R.id.etn_gracz2)
        etGracz3 = findViewById(R.id.etn_gracz3)
        etGracz4 = findViewById(R.id.etn_gracz4)
        etGracz1.visibility = View.INVISIBLE
        etGracz2.visibility = View.INVISIBLE
        etGracz3.visibility = View.INVISIBLE
        etGracz4.visibility = View.INVISIBLE
        imionaGraczyZatwierdz.visibility = View.INVISIBLE
        zatwierdz.setOnClickListener(View.OnClickListener { view -> zatwierdzenie() })

        liczbaGraczy.setOnFocusChangeListener(OnFocusChangeListener { view, b -> pobierzLiczbe(b) })
    }



    private fun zatwierdzenie() {
        liczbaGraczyInt = liczbaGraczy.text.toString().toInt()
        if(liczbaGraczyInt==null || liczbaGraczyInt==0 ){
            var toast: Toast
            toast = Toast.makeText(applicationContext, "Wprowadź liczbę graczy", Toast.LENGTH_SHORT)
            toast.show()
        }
        else{

            imionaGraczyZatwierdz.visibility = View.VISIBLE
            if(liczbaGraczyInt!! >=2 && liczbaGraczyInt!!<5){


                when(liczbaGraczyInt){
                    2-> {
                        etGracz1.visibility = View.VISIBLE
                        etGracz2.visibility = View.VISIBLE
                        listaImion.clear()
                        listaImion.add(etGracz1.text.toString())
                        listaImion.add(etGracz2.text.toString())
                    }
                    3-> {
                        etGracz1.visibility = View.VISIBLE
                        etGracz2.visibility = View.VISIBLE
                        etGracz3.visibility = View.VISIBLE
                        listaImion.clear()
                        listaImion.add(etGracz1.text.toString())
                        listaImion.add(etGracz2.text.toString())
                        listaImion.add(etGracz3.text.toString())
                    }
                    else -> {
                        etGracz1.visibility = View.VISIBLE
                        etGracz2.visibility = View.VISIBLE
                        etGracz3.visibility = View.VISIBLE
                        etGracz4.visibility = View.VISIBLE
                        listaImion.clear()
                        listaImion.add(etGracz1.text.toString())
                        listaImion.add(etGracz2.text.toString())
                        listaImion.add(etGracz3.text.toString())
                        listaImion.add(etGracz4.text.toString())
                    }
                }
                imionaGraczyZatwierdz.setOnClickListener(View.OnClickListener { view -> zatwierdzImiona() })
                var toast: Toast
                toast = Toast.makeText(applicationContext, liczbaGraczyInt.toString(), Toast.LENGTH_SHORT)
                toast.show()
            }
            else{
                var toast: Toast
                toast = Toast.makeText(applicationContext,"Ilość graczy musi być w przedziale 2-4", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

    }

    fun pobierzLiczbe(prawda:Boolean){
            var toast: Toast
            if(prawda==true) {
                liczbaGraczyInt=0
//
//                toast = Toast.makeText(applicationContext, "Kliknięty", Toast.LENGTH_SHORT)
//                toast.show()
            }
            else{


                toast = Toast.makeText(applicationContext, "Odkliknięty", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

    //    private fun addFragment (fragment:Fragment?){
//        if (fragment==null) return
//        val fm = supportFragmentManager
//        val tr = fm.beginTransaction()
//        tr.add(R.id.fragmlayout,fragment)
//        tr.commitAllowingStateLoss()
//        var curFragment = fragment
//    }
    private fun zatwierdzImiona() {

        var intent: Intent
        intent = Intent(this, ScoresActivity::class.java)
        intent.putExtra("Imiona",listaImion)
        intent.putExtra("Ilosc graczy",liczbaGraczyInt)
        startActivity(intent)

        //intent = Intent(this,)
    }
}