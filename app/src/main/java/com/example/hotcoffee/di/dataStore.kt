package com.example.hotcoffee.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.hotcoffee.data.local.TokenManager
import com.example.hotcoffee.data.remote.api.AuthApiService
import com.example.hotcoffee.data.remote.api.CoffeeApiService
import com.example.hotcoffee.data.remote.interceptors.AuthInterceptor
import com.example.hotcoffee.data.remote.repositories.AuthRepositoryImpl
import com.example.hotcoffee.domain.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data_store")

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager =
        TokenManager(context)

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(tokenManager: TokenManager): AuthInterceptor =
        AuthInterceptor(tokenManager)

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl("https://jwt-test-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())

    @Singleton
    @Provides
    fun provideAuthApiService(): AuthApiService =
        Retrofit.Builder()
            .baseUrl("http://212.41.30.90:35005")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)

    @Singleton
    @Provides
    fun provideCoffeeApiService(
        okHttpClient: OkHttpClient,
        retrofit: Retrofit.Builder
    ): CoffeeApiService =
        retrofit
            .client(okHttpClient)
            .build()
            .create(CoffeeApiService::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(authApiService: AuthApiService): AuthRepository =
        AuthRepositoryImpl(authService = authApiService)
}