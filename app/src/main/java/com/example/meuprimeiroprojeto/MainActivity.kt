package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val edt_altura: EditText = findViewById<EditText>(R.id.edt_altura)
        val edt_peso: EditText = findViewById<EditText>(R.id.edt_peso)
        val btn_calcular: Button = findViewById<Button>(R.id.btm_calcular)
    btn_calcular.setOnClickListener {

        val digaltura = edt_altura.text.toString()
        val digpeso = edt_peso.text.toString()

        if (digaltura.isNotEmpty() && digpeso.isNotEmpty()) {


        val altura: Float = digaltura.toFloat()
        val peso: Float = digpeso.toFloat()
        val result: Float = peso / (altura * altura)


        val intent = Intent(this, result_Activity::class.java)
            .apply {
                putExtra("extra_result", result)
            }
        startActivity(intent)

        }else{
            Toast.makeText(this, "PREENCHER TODOS OS CAMPOS", Toast.LENGTH_LONG).show()
        }
        }
    }
}