package com.example.sextatentativa.di

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiSevice: ApiService
) {

    suspend fun post(request: Request, app: String, auth: String, orig: String): Response<Flow<ResponseThis>> {
        return apiSevice.postRequest(request = request, app = app, auth = auth, orig = orig)
    }

    //
//
//    suspend fun pushPost2(
//        @Field("userId") userId: Int,
//        @Field("id") id: Int,
//        @Field("title") title: String,
//        @Field("body") body: String
//    ): Response<Post>

//    suspend fun getPost2(number: Int): Response<Post> {.
//        return RetrofitInstance.api.getPost2(number)
//    }
//
//    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
//        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
//    }
}