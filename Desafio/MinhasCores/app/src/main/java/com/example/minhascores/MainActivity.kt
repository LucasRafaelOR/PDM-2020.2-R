package com.example.minhascores

import CorAdapter
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var corDAO: CorDAO
    private lateinit var cores : ArrayList<Cor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.corDAO = CorDAO(this)
        this.cores = ArrayList<Cor>()

        val lvCores = findViewById<ListView>(R.id.lvCores)
        val adapter = CorAdapter(this, this.cores)
        lvCores.adapter = adapter

        lvCores.setOnItemClickListener { _, _, i, _ ->
            run {
                val itemclicked = adapter.getItem(i)
                val intent = Intent(this, ColorForm::class.java)
                intent.putExtra("COR", itemclicked)
                intent.putExtra("POS", i)
                startActivityForResult(intent, Companion.EDIT)
            }
        }

        lvCores.setOnItemLongClickListener { _, _, i, _ ->
            run {
                val cor = adapter.getItem(i)
                this.corDAO.delete(cor.id)
                adapter.delete(i)
                Toast.makeText(this, "${cor.nome} removido!", Toast.LENGTH_SHORT).show()
                return@setOnItemLongClickListener true
            }
        }

        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        fabAdd.setOnClickListener {
            val intent = Intent(this, ColorForm::class.java)
            startActivityForResult(intent, Companion.ADD)
        }

    }

    override fun onResume() {
        super.onResume()
        Log.i("MAIN", "resumed!")
        this.cores = this.corDAO.select()

        (findViewById<ListView>(R.id.lvCores).adapter as CorAdapter).setArray(this.cores)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val cor = data?.getSerializableExtra("COR") as Cor
            val adapter = findViewById<ListView>(R.id.lvCores).adapter as CorAdapter
            when (requestCode) {
                Companion.ADD -> {
                    this.corDAO.insert(cor)
                    Toast.makeText(this, "Cor adicionada!", Toast.LENGTH_SHORT).show()
                }
                Companion.EDIT -> {
                    this.corDAO.update(cor)
                    val pos = data.getIntExtra("POS", 0)
                    adapter.update(cor, pos)
                    Toast.makeText(this, "Cor atualizada!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val ADD = 1
        const val EDIT = 2
    }
}