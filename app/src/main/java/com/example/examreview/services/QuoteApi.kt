package com.example.examreview.services

import com.example.examreview.Quote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface QuoteApi{
    @GET("quotes")
    suspend fun getQuotes(): List<Quote>
}

object RetrofitClient {
    val api: QuoteApi = Retrofit.Builder()
        .baseUrl("https://type.fit/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuoteApi::class.java)
}