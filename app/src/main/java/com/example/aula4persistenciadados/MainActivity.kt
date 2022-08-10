package com.example.aula4persistenciadados

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encontra os elementos pelo ID e armazena em variaveis
        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var btnExibir = findViewById<Button>(R.id.btnExibir)
        var txtNome = findViewById<EditText>(R.id.txtNome)
        var listTratamento = findViewById<Spinner>(R.id.listTratamento)

        var db = DatabaseManager(this, "saudacoes")

        //Clica no botão salvar
        btnSalvar.setOnClickListener {
            //Remove do banco o que possui
            db.removeSaudacao()
            //Insere os dados
            db.insereSaudacao(1, txtNome.text.toString(), listTratamento.selectedItem.toString())
            // Exibe mensagem de sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        // Exibe o outro layout
        btnExibir.setOnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }
    }
}