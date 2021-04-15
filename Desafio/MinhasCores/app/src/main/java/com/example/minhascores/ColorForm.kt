package com.example.minhascores

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ColorForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_form)

        val corNome = findViewById<EditText>(R.id.etNome)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)
        val btnColor = findViewById<Button>(R.id.btnColor)

        val red = findViewById<SeekBar>(R.id.sbRed)
        val green = findViewById<SeekBar>(R.id.sbGreen)
        val blue = findViewById<SeekBar>(R.id.sbBlue)

        btnColor.setOnClickListener {
            val clipboard  = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val r = red.progress
            val g = green.progress
            val b = blue.progress
            val color =  String.format("#%06X", (0xFFFFFF and Color.rgb(r,g,b)))
            val clip = ClipData.newPlainText("color", color)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "${color} copiado!", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            finish()
        }

        red.setOnSeekBarChangeListener(SeekBarChange())
        blue.setOnSeekBarChangeListener(SeekBarChange())
        green.setOnSeekBarChangeListener(SeekBarChange())

        btnSalvar.setOnClickListener {
            returnColor()
        }

        if(intent.hasExtra("COR"))
        {
            val cor = intent.getSerializableExtra("COR") as Cor
            corNome.setText(cor.nome)
            red.progress = Color.red(cor.codigo)
            green.progress = Color.green(cor.codigo)
            blue.progress = Color.blue(cor.codigo)

            val pos = intent.getIntExtra("POS", -1)

            btnColor.text = cor.toHex()

            btnSalvar.setOnClickListener {
                returnColor(pos)
            }
        }
    }

    private fun returnColor(pos: Int? = -1)
    {
        val newintent = Intent()

        val nome = findViewById<EditText>(R.id.etNome).text.toString()
        val r = findViewById<SeekBar>(R.id.sbRed).progress
        val g = findViewById<SeekBar>(R.id.sbGreen).progress
        val b = findViewById<SeekBar>(R.id.sbBlue).progress

        val cor = if(pos != -1)
        {
            newintent.putExtra("POS", pos)
            val c = intent.getSerializableExtra("COR") as Cor
            c.codigo = Color.rgb(r,g,b)
            c.nome = nome
            c
        } else
        {
            Cor(nome, Color.rgb(r,g,b))
        }

        newintent.putExtra("COR",cor)
        setResult(Activity.RESULT_OK, newintent)
        finish()
    }

    private fun updateColor()
    {
        val colorbtn = findViewById<Button>(R.id.btnColor)
        val r = findViewById<SeekBar>(R.id.sbRed).progress
        val g = findViewById<SeekBar>(R.id.sbGreen).progress
        val b = findViewById<SeekBar>(R.id.sbBlue).progress
        val color = Color.rgb(r, g, b)
        colorbtn.text = String.format("#%06X", (0xFFFFFF and color))
        colorbtn.setBackgroundColor(color)
    }

    inner class SeekBarChange : SeekBar.OnSeekBarChangeListener
    {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            this@ColorForm.updateColor()
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {
            return
        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
            return
        }

    }

}
