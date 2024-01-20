package com.example.retrofitapp

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    // you should specify the end-pointsd of the urls

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

}