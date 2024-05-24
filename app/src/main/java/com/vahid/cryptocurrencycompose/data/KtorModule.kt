package com.vahid.cryptocurrencycompose.data

import com.google.gson.GsonBuilder
import com.vahid.cryptocurrencycompose.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.features.ContentNegotiation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton
import io.ktor.gson.*
import kotlinx.serialization.json.Json


@Module
@InstallIn(SingletonComponent::class)
abstract class KtorModule {

    @Singleton
    companion object {
        @OptIn(ExperimentalSerializationApi::class)
        @Provides
        fun provideHttpClient(): HttpClient {
            return HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
//                install(DefaultRequest) {
//
//                }

                install(JsonFeature) {
                    serializer = KotlinxSerializer(Json {
                        ignoreUnknownKeys=true
                    })
                }

//                install(ContentNegotiation) {
//                    gson {
//                        setPrettyPrinting()
//                        disableHtmlEscaping()
//                        registerTypeAdapter(yourClass, yourCustomAdapter)
//                    }
//                }

            }


        }

        @Provides
        @Singleton
        fun provideApiService(httpClient: HttpClient): ApiService = KtorApiServiceImpl(httpClient)

        @Provides
        fun provideDispatcher(): CoroutineDispatcher = Dispatchers.Default

        @Singleton
        @Provides
        fun provideMainRepository(apiService: ApiService): MainRepository {
            return MainRepositoryImpl(apiService)
        }


    }
}