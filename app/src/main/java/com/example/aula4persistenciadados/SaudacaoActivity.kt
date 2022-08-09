package com.example.aula4persistenciadados

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        //Encontra o elemento pelo ID
        var lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        //Recebe os valores da persistência
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        //Recebe a String da persistência
        val nome = saudacaoPersistencia.getString("nome", "")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        //Verifica se foi inserido um tipo de tratamento
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        } else{
            lbSaudacao.text = tratamento + " " + nome
        }
    }
}