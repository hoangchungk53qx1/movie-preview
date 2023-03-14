package com.example.core_data

sealed class LceState<out T> {
    object Loading : LceState<Nothing>()
    object None : LceState<Nothing>()
    data class Error(val message: String) : LceState<Nothing>()
    data class Success<T>(val item: T) : LceState<T>()
}