package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    private fun abrirCamera(){
        val intentCam = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intentCam.resolveActivity(packageManager) !=null){
            startActivity(intentCam)
        }
    }

    private fun abrirContatos(){
        val packageManager = this.packageManager
        if (packageManager != null){
            val intentContats = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            if (intentContats.resolveActivity(packageManager) != null){
                startActivity(intentContats)
            }
            else{
                Toast.makeText(this, "Nenhum App de contatos encontrado", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Erro no packgeManege", Toast.LENGTH_LONG).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_camera -> abrirCamera()
            R.id.action_contacts ->abrirContatos()
        }

        return super.onOptionsItemSelected(item)
    }

}
