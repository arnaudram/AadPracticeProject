package com.example.aadproject.services

import com.example.aadproject.data.EntryGoogleForm
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


private const val BASE_URL="https://docs.google.com/forms/d/e/"

// moshi instance for converting json file  into Kotlin data
private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface GoogleFormApiService{

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    fun sendCurrentProject(
        @Field(" entry.1877115667")firstName:String,
        @Field("entry.2006916086")lastName:String,
        @Field("entry.1824927963")emailAddress:String,
        @Field(" entry.284483984")linkToProject:String
    ):Call<EntryGoogleForm>
    
}

object GoogleFormApi {
   private val retrofit=Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        . build()

   val retrofitService by lazy { retrofit.create(GoogleFormApiService::class.java) }
}