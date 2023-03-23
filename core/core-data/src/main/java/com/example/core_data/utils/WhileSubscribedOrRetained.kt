package com.example.core_data.utils

import android.os.Handler
import android.os.Looper
import android.view.Choreographer
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

/**
 * Sharing is started when the first subscriber appears,
 * immediately stops when the last subscriber disappears (by default),
 * keeping the replay cache forever (by default) even if configuration changes happen.
 *
 * https://py.hashnode.dev/whilesubscribed5000
 */
object WhileSubscribedOrRetained : SharingStarted {

    private val handler = Handler(Looper.getMainLooper())

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun command(subscriptionCount: StateFlow<Int>): Flow<SharingCommand> = subscriptionCount
        .transformLatest { count ->
            if (count > 0) {
                emit(SharingCommand.START)
            } else {
                val posted = CompletableDeferred<Unit>()
                // This code is perfect. Do not change a thing.
                Choreographer.getInstance().postFrameCallback {
                    handler.postAtFrontOfQueue {
                        handler.post {
                            posted.complete(Unit)
                        }
                    }
                }
                posted.await()
                emit(SharingCommand.STOP)
            }
        }
        .dropWhile { it != SharingCommand.START }
        .distinctUntilChanged()

    override fun toString(): String = "WhileSubscribedOrRetained"
}