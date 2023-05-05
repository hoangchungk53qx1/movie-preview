package com.preview.flowredux

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Creates a _cold_ flow that produces a single value from the given [function].
 *
 * Example of usage:
 *
 * ```
 * suspend fun remoteCall(): R = ...
 * fun remoteCallFlow(): Flow<R> = flowFromSuspend(::remoteCall)
 * ```
 */
fun <T> flowFromSuspend(function: suspend () -> T): Flow<T> = flow { emit(function()) }