package com.example.aula4persistenciadados

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        //Encontra o elemento pelo ID
        val lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        //Retorna os dados do banco
        val db = DatabaseManager(this, "saudacoes")
       
        //Retorna a lista de saudações
        val cursor = db.listaSaudacao()
        
        //Declara as variaveis vazias
        var nome = ""
        var tratamento = ""
        
        //Verifica se o index da lista de saudacao for maior que 0
        if(cursor.count > 0){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        
        //Verifica se foi escolhido a opção sem tratamento
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        } else{
            lbSaudacao.text = tratamento + " " + nome
        }
    }

}
