package com.example.zd1_sedunova

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.ParsePosition

class MainActivity2 : AppCompatActivity() {
    lateinit var login: TextView
    var names = arrayListOf<String>("Сумерки","Реинкарнация","Путь")
    var select =""
    lateinit var ttt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        login=findViewById(R.id.textView)
        login.setText(intent.getStringExtra("login").toString())
         val spinner: Spinner = findViewById(R.id.spinner)
        ttt = findViewById(R.id.textfromspin)
        var ar = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,names)
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = ar
        spinner.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, itemSelected: View, selectedPosition: Int,SelectedId: Long) {
                select = names[selectedPosition]
                ttt.text = "Вы выбрали: "+select
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }




}