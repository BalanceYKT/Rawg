package com.example.rawg.network

import com.example.rawg.BASE_URL
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(): Interceptor{
  override fun intercept(chain: Interceptor.Chain): Response {
    var req = chain.request()
    val url = req.url.newBuilder()
      .addQueryParameter("APPID", BASE_URL)
      .build()
    req = req.newBuilder()
      .url(url)
      .build()
    return chain.proceed(req)
  }
}