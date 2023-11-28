package com.chungha.core_domain.utils

import kotlinx.coroutines.CancellationException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <R> runSuspendCatching(block: () -> R): Result<R> {
  contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
  return try {
    Result.success(block())
  } catch (c: CancellationException) {
    throw c
  } catch (e: Throwable) {
    Result.failure(e)
  }
}