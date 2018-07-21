package com.example.allef.next.kotlinmovilenext.api

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.temporal.TemporalQuery

class RepositoryRetriver {

    lateinit var  service:GitHubService



    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(GitHubService::class.java)
    }

    fun getLanguagesRepositories(callback:Callback<GithubRepositoriesResult>,query: String){
        val call = service.searchRepositories("language:$query")
        call.enqueue(callback)
    }
}