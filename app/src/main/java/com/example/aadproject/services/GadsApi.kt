package com.example.aadproject.services

import com.example.aadproject.data.EntityGads
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL="https://gadsapi.herokuapp.com/"

 /*moshi instance for converting json data into kotlin data*/

private val moshi= Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface GadsApiService {
    @GET(" api/hours")
    fun getLearningLeaders():Deferred<List<EntityGads>>

}

private val retrofit=Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())     // coroutine calladapter allows the return  type defered
    .baseUrl(BASE_URL)
    .build()

object GadsApi {
    val retrofitService by lazy {
        retrofit.create(GadsApiService::class.java)
    }
}

