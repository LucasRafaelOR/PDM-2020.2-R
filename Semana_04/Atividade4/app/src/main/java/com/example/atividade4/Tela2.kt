package com.example.atividade4

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import layout.Pessoa

class Tela2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val p = intent.getParcelableExtra<Pessoa>("MSG_IDA")
        val textView = findViewById<TextView>(R.id.textView2)
        textView.text = "${p?.nome}, você possui ${p?.idade()} anos!"
        textView.setOnClickListener{textClick()}
    }

    fun textClick() {
        finish()
    }
}