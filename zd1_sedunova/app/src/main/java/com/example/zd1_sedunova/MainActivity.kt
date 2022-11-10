package com.example.zd1_sedunova

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    public final var APP_PREFERENCES="settings"
    public final var APP_PREFERENCES_LOG="log"
    lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.edt1)
        password=findViewById(R.id.edt2)
        settings=getSharedPreferences(APP_PREFERENCES_LOG, MODE_PRIVATE)
        view(login)
    }
    fun onMyButtonClick(view: View?) {
        if(login.text.isNotEmpty() && password.text.isNotEmpty()){
            Toast.makeText(this, "Всё гуд", Toast.LENGTH_SHORT).show()
            saveName(login)
            val inf=login.text.toString()
            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("login",inf)
            startActivity(intent)

        }
        else{
            val alert=AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас незаполненные поля")
                .setPositiveButton("Ок",null)
                .create()
                .show()
        }

    }
    fun view(view: android.view.View){
        var name=settings.getString(APP_PREFERENCES,"Не определено")
        login.setText(name)
    }
    fun saveName(view: android.view.View){
        var name=login.getText().toString()
        var prefeditor=settings.edit()
        prefeditor.putString(APP_PREFERENCES,name)
        prefeditor.apply()
    }
}