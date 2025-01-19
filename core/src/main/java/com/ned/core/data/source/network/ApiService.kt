package com.ned.core.data.source.network

import com.ned.core.data.source.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") size: Int
    ) : UsersResponse
}