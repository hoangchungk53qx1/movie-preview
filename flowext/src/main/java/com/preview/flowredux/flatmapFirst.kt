package com.preview.flowredux

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

fun <T, R> Flow<T>.flatMapFirst(transform: suspend (value: T) -> Flow<R>): Flow<R> =
    map(transform).flattenFirst()

/**
 * Converts a higher-order [Flow] into a first-order [Flow] by dropping inner [Flow] while the previous inner [Flow] has not yet completed.
 */
fun <T> Flow<Flow<T>>.flattenFirst(): Flow<T> = channelFlow {
    val outerScope = this
    val busy = AtomicBoolean(false)

    collect { inner ->
        if (busy.compareAndSet(false, true)) {
            // Do not pay for dispatch here, it's never necessary
            launch(start = CoroutineStart.UNDISPATCHED) {
                try {
                    inner.collect { outerScope.send(it) }
                    busy.set(false)
                } catch (e: CancellationException) {
                    // cancel outer scope on cancellation exception, too
                    outerScope.cancel(e)
                }
            }
        }
    }
}

/**
 * This function is an alias to [flatMapFirst] operator.
 */
fun <T, R> Flow<T>.exhaustMap(transform: suspend (value: T) -> Flow<R>): Flow<R> =
    flatMapFirst(transform)

/**
 * This function is an alias to [flattenFirst] operator.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <T> Flow<Flow<T>>.exhaustAll(): Flow<T> = flattenFirst()