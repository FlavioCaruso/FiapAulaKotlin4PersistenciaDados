package com.example.aula4persistenciadados

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        //Encontra o elemento pelo ID
        val lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        //Executa a função de recuperar dados no arquivo
        val data = recuperaDadoArquivo("saudacao")

        //Quebra a string em tokens
        val tokenizer = StringTokenizer(data, ":")

        //Verifica se existe o dado, caso não exista exibe uma mensagem "Sem nome"
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"

        //Verifica se existe o dado, caso não exista exibe uma mensagem "Sem Tratamento"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Tratamento"

        //Verifica se foi inserido tratamento e retorna
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        }else{
            lbSaudacao.text = tratamento + " " + nome
        }
    }

    // Função que recupera os dados do arquivo
    fun recuperaDadoArquivo(filename: String) : String{
        //Tratamento de Exceções
        //Recuperar erros que podem ocorrer
        try{
            //Abre um arquivo privado e cria caso ele não exista
            val fi = openFileInput(filename)
            //Le os dados do arquivo em bytes
            val data = fi.readBytes()
            //Fecha o arquivo
            fi.close()
            //Transforma os dados em String
            data.toString()

            //Retorna os dados
            return data.toString(Charset.defaultCharset())
        //Tratamento dos erros
        } catch (e: FileNotFoundException){
            return ""
        } catch (e: IOException){
            return ""
        }
    }
}