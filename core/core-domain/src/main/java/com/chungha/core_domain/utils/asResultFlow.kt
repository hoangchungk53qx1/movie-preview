package com.chungha.core_domain.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

fun <T> Flow<T>.asResultFlow(): Flow<Result<T>> {
    return map { Result.success(it) }.catch { emit(Result.failure(it)) }
}