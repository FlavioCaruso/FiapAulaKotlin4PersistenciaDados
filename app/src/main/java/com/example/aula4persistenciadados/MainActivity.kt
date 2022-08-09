package com.example.aula4persistenciadados

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encontra os elementos pelo ID
        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var btnExibir = findViewById<Button>(R.id.btnExibir)
        var txtNome = findViewById<EditText>(R.id.txtNome)
        var listTratamento = findViewById<Spinner>(R.id.listTratamento)


        btnSalvar.setOnClickListener{

            //Cria preferências compartilhadas
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

            val editor = saudacaoPersistencia.edit()

            //Inclui os valores para persistência
            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())

            //Aplica os valores
            editor.apply()

            //Exibe a mensagem de sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        // Exibe o outro layout
        btnExibir.setOnClickListener{
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }


    }
}