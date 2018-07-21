package com.example.allef.next.kotlinmovilenext.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.allef.next.kotlinmovilenext.R
import com.example.allef.next.kotlinmovilenext.adapter.ProgrammingLanguageAdapter
import com.example.allef.next.kotlinmovilenext.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.adapter = ProgrammingLanguageAdapter(
                recyclerviewItems(),
                this) {
            longToast("clicked item : ${it.title}")
        }


        val layouManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layouManager




    }

    private fun recyclerviewItems():List<ProgrammingLanguage>{
        val kotlin = ProgrammingLanguage(
                R.drawable.kotlin,
                "Kotlin",
                2010,
                "\"Kotlin é uma Linguagem de programação que compila\n" +
                        "para a Máquina virtual Java e que também pode ser traduzida\n" +
                        "para JavaScript e compilada para código nativo. É\n" +
                        "desenvolvida pela JetBrains, seu nome é baseado na ilha de\n" +
                        "Kotlin onde se situa a cidade russa de Kronstadt, próximo à\n" +
                        "São Petersburgo. Apesar de a sintaxe de Kotlin diferir da de\n" +
                        "Java, Kotlin é projetada para ter uma interoperabilidade\n" +
                        "total com código Java. Foi considerada pelo público a 2a\n" +
                        "linguagem 'mais amada', de acordo com uma pesquisa conduzida\n" +
                        "pelo site Stack Overflow em 2018.\")"
        )
        return listOf(kotlin,kotlin) // retornando uma lista de kotlin
    }

}
