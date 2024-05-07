package com.example.sextatentativa.di

import android.util.Base64
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.sextatentativa.di.Constants.Companion.API_KEY
import com.example.sextatentativa.di.Constants.Companion.PUBLIC_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

interface ApiService {


    @POST("login")
    suspend fun login(@Body request: Request): Response<MutableStateFlow<ResponseThis>>


    @POST("/ipg/v1x/c2bPayment/singleStage/")
    suspend fun postRequest(
        @Header(value = "Content-type") app: String,
        @Header(value = "Authorization") auth: String,
        @Header(value = "Origin") orig: String,
        @Body request: Request
    ): Response<Flow<ResponseThis>>



}


