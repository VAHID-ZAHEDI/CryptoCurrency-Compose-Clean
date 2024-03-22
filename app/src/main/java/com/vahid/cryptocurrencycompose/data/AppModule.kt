package com.vahid.cryptocurrencycompose.data

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.vahid.cryptocurrencycompose.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL: String = "https://api-web.tabdeal.org/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): ApiService {
//        val client = OkHttpClient.Builder()
//            .addInterceptor(ChuckerInterceptor.Builder(app).build())
//            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiService): MainRepository {
        return MainRepositoryImpl(api)
    }
}