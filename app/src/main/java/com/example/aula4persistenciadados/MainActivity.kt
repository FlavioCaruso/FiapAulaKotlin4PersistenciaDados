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


        btnSalvar.setOnClickListener{
//          //Armazena os valores do EditText e do Spinner
            val data = txtNome.text.toString() + ": " + listTratamento.selectedItem.toString()

            //Executa a função de gravar dados no arquivo
            gravaDadoArquivo("saudacao", data)

//           //Exibe a mensagem de sucesso
            Toast.makeText(this,"Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        // Exibe o outro layout
        btnExibir.setOnClickListener{
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }
    }

    //Função de gravar os dados inputados em um arquiv
    fun gravaDadoArquivo(filename: String, data: String){
        //Tratamento de Exceções
        //Recuperar erros que podem ocorrer
        try{
            //Abre um arquivo privado e cria caso ele não exista
            val fs = openFileOutput(filename, Context.MODE_PRIVATE);

            //Inclui os dados e verifica o valor dos dados em bytes
            fs.write(data.toByteArray())

            //Fecha o arquivo
            fs.close()
        //Tratamento dos erros
        } catch ( e: FileNotFoundException){
            Log.i ("GravaDadoArquivo", "FileNotFoundException")
        } catch (e: IOException){
            Log.i("GravaDadoArquivo", "IOException")
        }
    }
}