package com.example.ifpb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Telefone ligou!", Toast.LENGTH_SHORT).show()
        Log.i("IFPB", "Received broadcast")
        val i = Intent(context, MainActivity::class.java)
        i.addFlags(FLAG_ACTIVITY_NEW_TASK)
        context.applicationContext.startActivity(i)
    }
}