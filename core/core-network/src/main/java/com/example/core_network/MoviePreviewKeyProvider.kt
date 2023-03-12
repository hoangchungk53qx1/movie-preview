package com.example.core_network

interface MoviePreviewKeyProvider {
    val apiKey: String?
}

fun MoviePreviewKeyProvider.requireApiKey() = checkNotNull(apiKey)