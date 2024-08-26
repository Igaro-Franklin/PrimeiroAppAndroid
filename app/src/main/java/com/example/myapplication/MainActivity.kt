package com.example.myapplication

import android.content.Intent
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    private fun openCamera(){
        val intentCam = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intentCam.resolveActivity(packageManager) !=null){
            startActivity(intentCam)
        }
    }

    private fun openContacts(){
        val intentContacts = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        if (intentContacts.resolveActivity(packageManager) !=null)
            startActivity(intentContacts)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_camera -> openCamera()
            R.id.action_contacts ->openContacts()
        }

        return super.onOptionsItemSelected(item)
    }

}