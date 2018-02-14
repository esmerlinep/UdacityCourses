package com.esmerlinp.udacitycourses.interactors.api

import com.esmerlinp.udacitycourses.interactors.Entities.CatalogEntity
import retrofit2.Call
import retrofit2.http.GET


interface UdaCityServices {
    companion object {
        val BASE_URL = "https://www.udacity.com/public-api/v0/"
    }

    @GET("courses")
    fun getCourses(): Call<CatalogEntity>
}