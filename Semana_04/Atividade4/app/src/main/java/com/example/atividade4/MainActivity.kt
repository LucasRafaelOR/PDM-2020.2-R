package com.example.atividade4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import layout.Pessoa

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener { clickCalcular(it) }
    }

    fun clickCalcular(view: View)
    {
        val intent = Intent(this, Tela2::class.java)
        val nome : EditText = findViewById(R.id.editTextTextPersonName)
        val ano : EditText = findViewById(R.id.editTextNumber)
        val pessoa : Pessoa = Pessoa(nome.text.toString(), ano.text.toString().toInt())
        intent.putExtra("MSG_IDA", pessoa)
        //startActivity(intent)
        startActivityForResult(intent, 1)
    }


}