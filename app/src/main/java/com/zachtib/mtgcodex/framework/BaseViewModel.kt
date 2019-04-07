package com.zachtib.mtgcodex.framework

import com.airbnb.mvrx.BaseMvRxViewModel
import com.zachtib.mtgcodex.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S : State>(initialState: S) : BaseMvRxViewModel<S>(initialState, BuildConfig.DEBUG),
    CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}