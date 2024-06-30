package net.softglobe.loginregistertutoriall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetofitInstance {
    val api by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.104/login-register/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}