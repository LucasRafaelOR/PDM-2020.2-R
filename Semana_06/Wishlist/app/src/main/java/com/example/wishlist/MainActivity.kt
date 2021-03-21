package com.example.wishlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var desejos : ArrayList<Desejo>
    private lateinit var lvDesejos : ListView
    private lateinit var fabAdd : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.desejos = ArrayList()
        this.fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        this.lvDesejos = findViewById<ListView>(R.id.lvDesejos)

        this.lvDesejos.adapter = ArrayAdapter<Desejo>(this, android.R.layout.simple_list_item_1, this.desejos)

        fabAdd.setOnClickListener { newDesejo() }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK)
        {
            if(requestCode == 1)
            {
                if(data?.hasExtra("NovoDesejo") == true)
                {
                    val novoDesejo = data?.getSerializableExtra("NovoDesejo") as Desejo
                    (this.lvDesejos.adapter as ArrayAdapter<Desejo>).add(novoDesejo)
                }
            }
        }


    }

    fun newDesejo()
    {
        val i = Intent(this, NovoActivity::class.java)
        startActivityForResult(i, 1);
    }
}