package com.example.rawg.network

import com.example.rawg.Util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
  return Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
  return OkHttpClient().newBuilder()
    .addInterceptor(authInterceptor)
    .addInterceptor(loggingInterceptor)
    .build()
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
  val logger = HttpLoggingInterceptor()
  logger.level = HttpLoggingInterceptor.Level.BASIC
  return logger
}

fun provideGameApi(retrofit: Retrofit): RawgService = retrofit.create(RawgService::class.java)