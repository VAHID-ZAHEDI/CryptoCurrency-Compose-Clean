package com.example.tabdeal.network



import com.google.gson.GsonBuilder
import com.vahid.cryptocurrencycompose.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


private const val BASE_URL: String = "https://api.tabdeal.ir/"

/**
 * Api client structure of Api request
 *
 * @constructor Create empty Api client
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiClient {
    private val client = OkHttpClient.Builder()


    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(): ApiService {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val gson = GsonBuilder()
            .setLenient()
            .create()

        client.readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor(ChuckerInterceptor(AppConfig.getMyApplicationContext()))
            .connectTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

            .client(client.build())
            .build().create(ApiService::class.java)
    }


}