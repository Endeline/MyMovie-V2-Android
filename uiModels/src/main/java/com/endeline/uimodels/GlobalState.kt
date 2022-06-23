package com.endeline.uimodels

sealed class GlobalState<out T : Any> {
    object Loading : GlobalState<Any>()
    data class Loaded<out T: Any>(
        val data: T
    ) : GlobalState<T>()

    data class Error<out T: Any>(
        val error: T
    ) : GlobalState<T>()
}
