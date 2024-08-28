package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AlertDialog

fun alerta(context: Context, titulo: String, mensagem: String){
    val builder = AlertDialog.Builder(context)

    builder.setTitle(titulo)
    builder.setMessage(mensagem)

    builder.setPositiveButton("Sim"){
        dialog, _ -> (context as Activity).finish()
        dialog.dismiss()
    }

    builder.setNegativeButton("Não"){
        dialog, _ -> dialog.dismiss()
    }


    val exibirAlerta = builder.create()
    exibirAlerta.show()
}
