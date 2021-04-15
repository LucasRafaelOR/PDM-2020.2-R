package com.example.minhascores

import android.content.ContentValues
import android.content.Context
import android.util.Log

class CorDAO {
    private var banco: BancoHelper;

    constructor(context: Context)
    {
        this.banco = BancoHelper(context)
    }

    fun insert(cor : Cor) : Int
    {
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)

        val id = this.banco.writableDatabase.insert("cor", null, cv).toInt()
        Log.i("CORDAO", id.toString())
        return id
    }

    fun select() : ArrayList<Cor>
    {
        val lista = ArrayList<Cor>()
        val colunas = arrayOf("id", "nome", "codigo")
        val cursor = this.banco.readableDatabase.query("cor", colunas, null, null, null, null, "id")

        cursor.moveToFirst()

        for(i in 1..cursor.count)
        {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nome = cursor.getString(cursor.getColumnIndex("nome"))
            val codigo = cursor.getInt(cursor.getColumnIndex("codigo"))

            lista.add(Cor(id, nome, codigo))
            cursor.moveToNext()
        }
        Log.i("CORDAO", lista.toString())
        return lista
    }

    fun find(id: Int) : Cor?
    {
        val colunas = arrayOf("id", "nome","codigo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.banco.readableDatabase.query("cor", colunas, where, pWhere, null, null, null)

        cursor.moveToFirst()

        if(cursor.count == 1)
        {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nome = cursor.getString(cursor.getColumnIndex("nome"))
            val codigo = cursor.getInt(cursor.getColumnIndex("codigo"))

            return Cor(id, nome, codigo)
        }
        return null

    }

    fun update(cor : Cor)
    {
        val where = "id = ?"
        val pWhere = arrayOf(cor.id.toString())

        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)

        this.banco.writableDatabase.update("cor", cv, where, pWhere)
    }

    fun delete(id: Int)
    {
        this.banco.writableDatabase.delete("cor", "id = ?", arrayOf(id.toString()))
    }


}