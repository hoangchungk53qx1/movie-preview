package com.chungha.core_network

import okhttp3.Interceptor
import okhttp3.Response

internal class MoviePreAuthInterceptor(private val apiKeyProvider: MoviePreviewKeyProvider) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY_PARAM, apiKeyProvider.requireApiKey())
            .build()

        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }

    private companion object {
        private const val API_KEY_QUERY_PARAM = Constants.API_KEY_QUERY_PARAM
    }
}