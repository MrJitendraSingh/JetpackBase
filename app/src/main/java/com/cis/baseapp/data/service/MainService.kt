package com.cis.baseapp.data.service

import com.cis.baseapp.data.model.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MainService {

/*    @GET("api/")
    suspend fun getQueryImages(
        @Query("q") query:String,
        @Query("key") apiKey:String,
        @Query("image_type") imageType:String
    ): PixabayResponse  */

    @GET("api/")
    suspend fun getQueryImages(@QueryMap hashMap: HashMap<String, String>): PixabayResponse
}