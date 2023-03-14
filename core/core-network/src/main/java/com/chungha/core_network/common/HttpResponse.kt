package com.chungha.core_network.common

internal interface HttpResponse {
    val statusCode: Int
    val statusMessage: String?
    val url: String?
}