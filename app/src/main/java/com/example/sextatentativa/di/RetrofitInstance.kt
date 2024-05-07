package com.example.sextatentativa.di


import com.example.sextatentativa.di.Constants.Companion.BASE_URL
import com.example.sextatentativa.di.Constants.Companion.PORT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {


    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()
/*

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        RetrofitInstance.retrofit.create(ApiService::class.java)
    }*/

    // Construir a URL base com a porta
    val httpUrl = HttpUrl.Builder()
        .scheme("https") // ou "https" se for o caso
        .host(BASE_URL)
        .port(PORT)
        .build()





    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(httpUrl)
            //.client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }




}