package com.example.aadproject.services

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private const val BASE_URL="https://docs.google.com/forms/d/e/"

// moshi instance for converting json file  into Kotlin data
private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface GoogleFormApiService{
    // implement a post request here
    
}

object GoogleFormApi {
   private val retrofit=Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        . build()

  private  val retrofitService by lazy { retrofit.create(GoogleFormApiService::class.java) }
}