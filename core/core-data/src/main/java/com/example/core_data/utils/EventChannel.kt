package com.example.core_data.utils

import android.util.Log
import androidx.annotation.MainThread
import com.chungha.movie_preview.core.data.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.onSuccess
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import java.io.Closeable
import javax.inject.Inject
import kotlin.coroutines.ContinuationInterceptor

interface HasEventFlow<E> {
    val eventFlow: Flow<E>
}

suspend fun debugCheckImmediateMainDispatcher() {
    if (BuildConfig.DEBUG) {
        val interceptor = currentCoroutineContext()[ContinuationInterceptor]
        Log.d(
            "###",
            "debugCheckImmediateMainDispatcher: $interceptor, ${Dispatchers.Main.immediate}, ${Dispatchers.Main}"
        )

        check(interceptor === Dispatchers.Main.immediate) {
            "Expected ContinuationInterceptor to be Dispatchers.Main.immediate but was $interceptor"
        }
    }
}

@MainThread
class EventChannel<E> @Inject constructor() : Closeable, HasEventFlow<E> {
    private val _eventChannel = Channel<E>(Channel.UNLIMITED)

    override val eventFlow: Flow<E> = _eventChannel.receiveAsFlow()

    init {
        Log.d("[EventChannel] created:", "hashCode=${System.identityHashCode(this)}")
    }

    /**
     * Must be called in Dispatchers.Main.immediate, otherwise it will throw an exception.
     * If you want to send an event from other Dispatcher,
     * use `withContext(Dispatchers.Main.immediate) { eventChannel.send(event) }`
     */
    @MainThread
    suspend fun send(event: E) {
        // https://github.com/Kotlin-Android-Open-Source/Jetpack-Compose-MVI-Coroutines-Flow/blob/master/core-ui/src/main/java/com/hoc/flowmvi/core_ui/checkImmediateMainDispatcher.kt
        debugCheckImmediateMainDispatcher()

        _eventChannel.trySend(event)
            .onFailure {
                Log.e(
                    "[EventChannel]",
                    "[EventChannel] Failed to send event: $event, hashCode=${
                        System.identityHashCode(
                            this
                        )
                    }"
                )
            }
            .onSuccess {
                Log.d(
                    "[EventChannel]",
                    "Sent event: $event, hashCode=${System.identityHashCode(this)}"
                )
            }
            .getOrThrow()
    }

    override fun close() {
        Log.d("[EventChannel]", "closed: hashCode=${System.identityHashCode(this)}")
        _eventChannel.close()
    }
}