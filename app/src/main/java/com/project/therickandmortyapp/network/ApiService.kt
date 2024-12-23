package com.project.therickandmortyapp.network

import com.project.therickandmortyapp.model.ApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters(): Call<ApiResponse>

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
