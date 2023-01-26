package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.core.app.NotificationCompatSideChannelService

class result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val result = intent.getFloatExtra("extra_result", 0.0f)
        val tvresult = findViewById<TextView>(R.id.result_text)
        val tvclas = findViewById<TextView>(R.id.tv_class)

        tvresult.text = result.toString()
        /*ENOR QUE 18,5	MAGREZA	0
        ENTRE 18,5 E 24,9	NORMAL	0
        ENTRE 25,0 E 29,9	SOBREPESO	I
        ENTRE 30,0 E 39,9	OBESIDADE	II
        MAIOR QUE 40,0 OBESIDADE GRAVE  */

        var classificacao = ""

        classificacao = if (result < 18.5f) {
            "MAGRESA"
        } else if (result >= 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if (result > 24.9f && result <= 29.9f) {
            "SOBREPESO"
        } else if (result > 29.9f && result <= 39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }
        tvclas.text = getString(R.string.message_clacificação, classificacao.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}