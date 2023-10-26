package com.soar.mvi.core

sealed class FetchStatus {
    object Fetching : FetchStatus()
    object Fetched : FetchStatus()
    object NotFetched : FetchStatus()
    data class Error(val errorCode: Int) : FetchStatus()
}

data class ViewState<T>(
    val fetchStatus: FetchStatus = FetchStatus.NotFetched,
    val data: T? = null
)