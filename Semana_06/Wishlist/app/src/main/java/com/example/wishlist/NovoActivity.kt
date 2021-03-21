package com.example.wishlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NovoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo)

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        btnCadastrar.setOnClickListener { cadastrar() }
        btnCancelar.setOnClickListener { cancelar() }
    }

    fun cancelar()
    {
        finish()
    }

    fun cadastrar() {
        val i = Intent()
        val valor = findViewById<EditText>(R.id.valor)
        val descricao = findViewById<EditText>(R.id.descricao)

        val desejo = Desejo(descricao.text.toString(), valor.text.toString().toFloat())
        i.putExtra("NovoDesejo", desejo)
        setResult(Activity.RESULT_OK, i)
        finish()
    }
}