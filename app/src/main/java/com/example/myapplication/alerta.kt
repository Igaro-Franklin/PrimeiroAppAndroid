package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun alerta(context: Context, titulo: String, mensagem: String){
    val builder = AlertDialog.Builder(context)

    builder.setTitle(titulo)
    builder.setMessage(mensagem)

    val exibirAlerta = builder.create()
    exibirAlerta.show()
}
