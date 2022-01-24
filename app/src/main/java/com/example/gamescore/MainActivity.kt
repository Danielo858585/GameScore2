package com.example.gamescore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        var button: ImageButton
        var karty: Intent
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.ib_cards)
        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.ib_cards->{
                intent = Intent(this@MainActivity,CardsActivity::class.java)
                startActivity(intent)
            }
        }
    }

}